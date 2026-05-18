///  https://leetcode.com/problems/longest-strictly-increasing-subsequence-with-non-zero-bitwise-and/description/


class Solution {
    public int longestSubsequence(int[] nums) {
        ArrayList<Integer>[] arrayLists = new ArrayList[31];
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if((num & (1<<i)) != 0)
                    arrayLists[i].add(num);
            }
        }

        int ans = 0;
        int[] tails = new int[nums.length];

        for(var list : arrayLists){
            if(list.size() <= ans) continue;
            
            int longestSubsequence = 0;
            for (int num : list){

                int l = 0, r=longestSubsequence;
                while(l<r){
                    int mid = (l+r) >> 1;
                    if(tails[mid] < num){
                        l = mid+1;
                    } else{
                      r = mid;   
                    }
                }
                
                tails[l] = num;
                if(l == longestSubsequence)
                    longestSubsequence++;
            }
            
            ans = Integer.max(ans, longestSubsequence);
        }
        
        return ans;
    }
}
