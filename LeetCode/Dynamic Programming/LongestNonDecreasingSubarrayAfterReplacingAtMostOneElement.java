///  https://leetcode.com/problems/longest-non-decreasing-subarray-after-replacing-at-most-one-element/description/

class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 1, n = nums.length;
        int[] inc = new int[n+1], dec = new int[n+1]; 
        inc[1] = dec[n-1] = 1;

        for(int i=1; i<nums.length; ++i){
            if(nums[i] >= nums[i-1])
                inc[i+1] = inc[i] + 1;
            else inc[i+1] = 1;
        }

        for(int i=n-2; i>=0; --i){
            if(nums[i] <= nums[i+1])
                dec[i] = dec[i+1]+1;
            else dec[i] = 1;
        }


        for(int i=0; i<n; ++i){
            int prev = i>0 ? nums[i-1] : Integer.MIN_VALUE;
            int next = i+1<n ? nums[i+1] : Integer.MAX_VALUE;

            if(prev <= next) ans = Integer.max(ans, inc[i]+dec[i+1]+1);
            else {
                ans = Integer.max(ans, inc[i]+1);
                ans = Integer.max(ans, dec[i+1]+1);
            }
        }

        return ans; 
    }

}