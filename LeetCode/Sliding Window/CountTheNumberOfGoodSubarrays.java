///  https://leetcode.com/problems/count-the-number-of-good-subarrays/description/

class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>(); 
        long ans = 0; 
        int left=0, right=0, n=nums.length, pairs = 0;
        
        while(left < n){
            while(pairs < k && right < n){
                int num = nums[right++];
                int numCount = mp.getOrDefault(num, 0);
                mp.put(num, numCount + 1);
                pairs += numCount;
            }

            if(pairs >= k)
                ans += n-right+1;        

            int num = nums[left++];
            int numCount = mp.get(num);
            mp.put(num, numCount - 1);
            pairs -= numCount-1;
        }
        return ans;
    }
}