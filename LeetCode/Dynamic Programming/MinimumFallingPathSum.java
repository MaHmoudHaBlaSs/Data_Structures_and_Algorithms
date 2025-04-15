///   https://leetcode.com/problems/minimum-falling-path-sum/description/

class Solution {
    final int oo = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; 
        int[][] dp = new int[n][n]; 

        for(int i=0; i<n;i++){
            for(int j=0; j<n ;j++)
                if(i == 0) dp[i][j] = matrix[i][j]; 
                else dp[i][j] = oo;  
        }

        for(int i=0; i<n-1;i++){
            for(int j=0; j<n ;j++){
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + matrix[i+1][j]);

                if(j > 0) 
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + matrix[i+1][j-1]); 

                if(j+1 < n) 
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + matrix[i+1][j+1]); 
            }
        }       

        int ans = oo; 
        for(int num : dp[n-1]) 
            if(num < ans) ans=num; 

        return ans;  
    }
}