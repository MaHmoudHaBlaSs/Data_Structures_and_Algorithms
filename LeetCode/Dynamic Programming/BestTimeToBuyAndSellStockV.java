/// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/description/

class Solution {
    private static final long NEG_INF = Long.MIN_VALUE >> 1;

    private long[][][] dp;
    private int[] prices;
    private int n;

    private long solve(int i, int t, int state) {
        if (i == n)
            return state == 0 ? 0 : NEG_INF;

        if (t == 0 && state != 0)
            return NEG_INF;

        if (dp[i][t][state] != Long.MIN_VALUE)
            return dp[i][t][state];

        long ans;

        if (state == 0) {
            ans = Math.max(
                solve(i + 1, t, 0),
                Math.max(
                    -prices[i] + solve(i + 1, t, 1), // start long
                    +prices[i] + solve(i + 1, t, 2)  // start short
                )
            );
        }
        else if (state == 1) { //long
            ans = Math.max(
                solve(i + 1, t, 1),
                +prices[i] + solve(i + 1, t - 1, 0)  // sell
            );
        }
        else {
            ans = Math.max( //short
                solve(i + 1, t, 2),
                -prices[i] + solve(i + 1, t - 1, 0)  // buy back
            );
        }

        return dp[i][t][state] = ans;
    }

    public long maximumProfit(int[] prices, int k) {
        this.prices = prices;
        this.n = prices.length;

        dp = new long[n][k + 1][3];
        for (int i = 0; i < n; i++)
            for (int t = 0; t <= k; t++)
                Arrays.fill(dp[i][t], Long.MIN_VALUE);

        return solve(0, k, 0);
    }
}