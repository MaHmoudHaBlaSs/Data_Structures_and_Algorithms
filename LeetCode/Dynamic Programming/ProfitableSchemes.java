///   https://leetcode.com/problems/profitable-schemes/description/

//Time & Space: O(n^3)   
class Solution {
    private int[][][] dp; 
    int[] g,p;
    final int MOD = 1_000_000_007; 

    private int solve(int i, int n, int minProfit){
        if(i >= g.length) 
            return minProfit == 0 ? 1 : 0;

        if(dp[i][n][minProfit] != -1) 
            return dp[i][n][minProfit]; 
        
        int ans=0; 
        //option 1: take the current profit if the available members >= group[i]  
        if(g[i] <= n ){     
            ans = solve(i+1,n-g[i], Math.max(minProfit - p[i],0));
        }

        //option 2: leave the current profit and go  
        ans = (ans + solve(i+1,n, minProfit)) % MOD; 

        return dp[i][n][minProfit] = ans; 
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        g = group; 
        p = profit; 
        dp = new int[g.length][n+1][minProfit+1]; 

        for(int i=0;i<group.length; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0,n,minProfit);
    }
}
