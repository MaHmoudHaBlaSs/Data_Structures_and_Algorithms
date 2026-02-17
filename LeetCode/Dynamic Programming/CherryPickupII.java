///   https://leetcode.com/problems/cherry-pickup-ii/description/

class Solution {
    private int[][][] memo;
    private int n,m; 
    
    private int solve(int i, int j1, int j2, int[][] grid){
        if(memo[i][j1][j2] != -1) return memo[i][j1][j2];
        
        int curr = grid[i][j1];
        if(j1 != j2) curr += grid[i][j2];
        
        if(i+1 == n) return curr;
        
        int bestOption = 0;
        for(int k1=-1; k1<2; ++k1) {
            int nextJ1 = j1+k1;
            if(nextJ1 < 0 || nextJ1 >= m) continue;
            
            for(int k2=-1; k2<2; ++k2) {
                int nextJ2 = j2+k2;
                if(nextJ2 < 0 || nextJ2 >= m) continue;
                
                bestOption = Math.max(bestOption, solve(i+1, nextJ1, nextJ2, grid));
            }
        }
        
        return memo[i][j1][j2] = memo[i][j2][j1] = curr + bestOption;
    }

    public int cherryPickup(int[][] grid) {
        n=grid.length; m=grid[0].length;
        memo = new int[n][m][m];

        for(int i=0;i<n; ++i) {
            for(int j=0;j<m; ++j) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return solve(0, 0, m-1, grid);
    }
}