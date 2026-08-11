///  https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/description/

class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis1 = new boolean[n][m];
        boolean[][] path = new boolean[n][m];
        
        if(!dfs(0,0,n,m,grid,vis1,path))
            return true;

        return !dfs(0,0,n,m,grid, path, new boolean[n][m]);
    }

    private boolean dfs(int i, int j, int n, int m, int[][] grid, boolean[][] vis, boolean[][] path){
        if(i== n-1 && j == m-1) return true;
        vis[i][j] = true;

        if(i+1 < n && grid[i+1][j] == 1 && !vis[i+1][j]){
            if(dfs(i+1,j,n,m, grid, vis, path)){
                path[i][j] = true;
                return true;
            }
        }

        if(j+1 < m && grid[i][j+1] == 1 && !vis[i][j+1]){
            if(dfs(i,j+1,n,m, grid, vis, path)){
                path[i][j] = true;
                return true;
            }
        }

        return false;
    }

}