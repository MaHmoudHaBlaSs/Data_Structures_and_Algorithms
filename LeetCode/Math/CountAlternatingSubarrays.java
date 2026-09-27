/// https://leetcode.com/problems/count-alternating-subarrays/description/

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length; 
        long ans = 0;

        for(int i=0; i<n; ++i){
            int j=i; 
            while(j+1 <n && nums[j+1] != nums[j]){
                j++;
            }

            long c = j-i+1;
            ans += (c+1)*c / 2;
            i = j;
        }

        return ans;
    }
}