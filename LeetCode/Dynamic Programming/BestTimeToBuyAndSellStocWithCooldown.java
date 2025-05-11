///  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

class Solution {
    private final int BOUGHT = 0, SOLD = 1;

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][BOUGHT] = -prices[0]; 

        for(int i=1; i<prices.length; i++){
            //Case 1: buy at ith day or you bought yesterday 
            int op1 = (i-2 >= 0 ? dp[i-2][SOLD]  : 0) - prices[i];
            dp[i][BOUGHT] = Math.max(op1, dp[i-1][BOUGHT]);

            //Case 2: sell at ith day or you sold yesterday
            int op2 = dp[i-1][BOUGHT] + prices[i];
            dp[i][SOLD] = Math.max(op2, dp[i-1][SOLD]);   
        }

        return dp[prices.length-1][SOLD]; 
    }
}