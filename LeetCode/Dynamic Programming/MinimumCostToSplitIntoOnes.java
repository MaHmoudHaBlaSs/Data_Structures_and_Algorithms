///   https://leetcode.com/problems/minimum-cost-to-split-into-ones/description/


public class Solution {
    public int minCost(int n) {
        int[] dp = new int[n + 1];

        for (int len = 2; len <= n; len++) {
            dp[len] = Integer.MAX_VALUE;

            for (int i = 1; i < len; i++) {
                int j = len - i;
                int cost = i * j + dp[i] + dp[j];
                dp[len] = Math.min(dp[len], cost);
            }
        }

        return dp[n];
    }
}