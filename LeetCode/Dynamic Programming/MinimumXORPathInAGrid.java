///  https://leetcode.com/problems/minimum-xor-path-in-a-grid/description/

class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][][] dp= new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<1024;k++){

                    if(dp[i][j][k]){
                        if(j+1<n)
                            dp[i][j+1][k^grid[i][j+1]] = true;
                        if(i+1<m)
                            dp[i+1][j][k^grid[i+1][j]] = true;
                    }
                }
            }
        }

        for(int i=0; i<1024; i++){
            if(dp[m-1][n-1][i]) return i;
        }
        
        return 0;
    }
}