///  https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/description/

class Solution {
    private static final long MOD = 1_000_000_007L;
    private int n,m;
    private int[][][] dp;

    private int solve(int i, int k, int max){
        if(i==n) return 1;
        
        if(dp[i][k][max] != -1) return dp[i][k][max];
        
        long res = 0;
        int rem = n-i-1; 
        if(k <= rem){
            res = ((long) max * solve(i + 1, k, max)) % MOD;
        }
        
        if(k >= 1){
            for(int j = max+1; j<=m && m-j+1 >= k; ++j){
                res = (res + solve(i+1, k-1, j)) % MOD;
            }   
        }
        
        return dp[i][k][max] = (int)res;
    }

    public int numOfArrays(int n, int m, int k) {
        this.n=n;
        this.m=m;
        dp = new int[n][k+1][m+1];

        for(int i=0; i<n;i++){
            for(int j=0; j<=k;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return solve(0, k,0);
    }
}