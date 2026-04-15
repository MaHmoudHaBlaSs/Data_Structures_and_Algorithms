/// https://leetcode.com/problems/minimum-increase-to-maximize-special-indices/description/


class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];

        //cost to make index i a peak
        for (int i = 1; i < n - 1; i++) {
            dp[i] = Math.max(0,
                        Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1);
        }

        for (int i = 3; i < n - 1; i++) {
            dp[i] += (i&1) == 0 ? Math.min(dp[i - 2], dp[i - 3]) : dp[i-2];
        }


        if ((n & 1) == 1) {
            return dp[n - 2];
        } else {
            return Math.min(dp[n - 2], dp[n - 3]);
        }
    }
}