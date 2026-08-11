///  https://leetcode.com/problems/visit-array-positions-to-maximize-score/description/

class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[2][n]; 
        dp[0][0] = dp[1][0] = nums[0] - x;
        dp[(nums[0]&1)][0] += x;

        for(int i=1; i<n; ++i){
            int parity = (nums[i] & 1);

            dp[parity^1][i] = dp[parity^1][i-1];

            dp[parity][i] = Long.max(
                    dp[parity][i-1] + nums[i],
                    dp[parity^1][i-1] + nums[i] - x
                );
        }

        return Long.max(dp[0][n-1], dp[1][n-1]);
    }
}