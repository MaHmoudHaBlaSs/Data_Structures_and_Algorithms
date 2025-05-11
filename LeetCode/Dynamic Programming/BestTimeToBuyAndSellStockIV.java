///  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
/*
State: dp[bought][i][k]
    bought is flag: 1 if holding stock, 0 if not.
    i is the current day.
    k is the remaining number of allowed transactions (full buy+sell pairs).
Transitions:
    1-If you don't own a stock (bought == 0), you can:
        Buy: pay prices[i], move to bought == 1, same k.
        Skip: stay in bought == 0, move to day i + 1.
    2-If you do own a stock (bought == 1), you can:
        Sell: earn prices[i], move to bought == 0, decrease k by 1.
        Hold: stay in bought == 1, move to day i + 1
*/

class Solution {
    private int dp[][][];
    private int n ;
    private int[] prices; 

    private int solve (int bought, int i, int k){
        if(i == n) return 0;

        if(dp[bought][i][k] != -1) return dp[bought][i][k];

        //Buy or sell
        int op1 = 0; 
        if(bought == 1) op1 = prices[i] + solve(0, i+1, k-1);
        else if(k > 0) op1 = solve(1,i+1, k) - prices[i];

        //Don't buy or sell
        int op2 = solve(bought, i+1, k); 

        return dp[bought][i][k] = Math.max(op1, op2); 
    }

    public int maxProfit(int k, int[] prices) {
        n = prices.length; 
        this.prices = prices; 
        dp = new int[2][n][k+1];    

        for(int i=0 ;i<2; i++)
            for(int j=0; j<n; j++) Arrays.fill(dp[i][j], -1);

        return solve(0,0,k); 
    }
}