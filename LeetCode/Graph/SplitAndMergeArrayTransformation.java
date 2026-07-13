///  https://leetcode.com/problems/split-and-merge-array-transformation/description/

class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        HashSet<String> vis = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(nums1);

        int ans = 0, n= nums1.length;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int[] top = q.poll();

                if(Arrays.equals(top, nums2))
                    return ans;

                for(int l=0;l<n;l++){
                    for(int r=l;r<n;r++){
                        for (int ins = 0; ins <=  n-(r-l+1); ins++) {
                            int[] candidate = splitAndMerge(top, l,r, ins);

                            String hash = Arrays.toString(candidate);
                            if(!vis.contains(hash)){
                                vis.add(hash);
                                q.offer(candidate);
                            }
                        }
                    }
                }
            }

            ans++;
        }
        
        return -1;
    }

    private int[] splitAndMerge(int[] nums, int l, int r, int insertionPoint){
        int[] ans = new int[nums.length];
        int window = r - l + 1, ansIdx=0,j=0;


        for(int i=0; i< nums.length; i++){
            if(i<l || i>r){
                if(ansIdx >= insertionPoint && ansIdx < insertionPoint+window){
                    ansIdx = insertionPoint+window;
                }

                ans[ansIdx++] = nums[i];

            }else {
                ans[insertionPoint + j] = nums[i];
                ++j;
            }
        }
        
        return ans;
    }
}