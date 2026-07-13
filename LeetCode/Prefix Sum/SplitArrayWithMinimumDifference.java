///  https://leetcode.com/problems/split-array-with-minimum-difference/description/

class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long rightSum = nums[n-1], leftSum = 0, ans = Long.MAX_VALUE;
        boolean[] dec = new boolean[n];

        dec[n-1] = true;

        for(int i=n-2; i>=0; --i){
            rightSum += nums[i];
            dec[i] = dec[i+1] & nums[i] > nums[i+1];
        }

        boolean inc = true;
        for(int i=0; i<n-1 && inc; ++i){
            leftSum += nums[i];
            rightSum -= nums[i];

            if(inc & dec[i+1]) 
                ans = Long.min(ans, Math.abs(rightSum - leftSum));

            inc &= nums[i+1] > nums[i];
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}
