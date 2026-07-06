///  https://leetcode.com/problems/count-ways-to-choose-coprime-integers-from-rows/description/

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countCoprime(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][151];
        
        for(int i=0; i<m; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        long ans = 0;
        for(int i=0; i<n; ++i){
            ans = (ans + solve(1, mat[0][i], mat, dp)) % MOD;
        }

        return (int)ans;
    }

    private int solve(int r, int currGcd, int[][] mat, int[][] dp){
        if(r >= mat.length){
            if(currGcd == 1) return 1;
            return 0;
        }

        if(dp[r][currGcd] != -1) return dp[r][currGcd];

        long ans = 0;
        for(int c=0; c<mat[r].length; c++){
            ans = (ans + solve(r+1, gcd(mat[r][c], currGcd), mat, dp)) % MOD;
        }

        return dp[r][currGcd] = (int)ans;
    }
    
    private int gcd(int a, int b){
        while(b>0){
            int rem = a%b;
            a = b;
            b = rem;
        }
        
        return a;
    }
   
}