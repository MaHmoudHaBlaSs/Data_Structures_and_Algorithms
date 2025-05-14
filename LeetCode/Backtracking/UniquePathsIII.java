///   https://leetcode.com/problems/unique-paths-iii/description/


class Solution {
    private int[][] grid;
    private int ans = 0, n,m, non_obstacle, count=0;
    
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        n = grid.length; m = grid[0].length;

        int r=0,c=0;
        for(int i=0; i<n ; i++){
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
                if(grid[i][j] == 0 || grid[i][j] == 1) non_obstacle++;
            }
        }

        solve(r,c);
        return ans;
    }

    private void solve(int r,int c){
        if(grid[r][c] == 2){
            if(count == non_obstacle) ans++;
            return;
        }

        grid[r][c] = -1;
        count++;
        
        if(r+1 < n && grid[r+1][c] != -1) solve(r+1,c);
        if(r-1 >= 0 && grid[r-1][c] != -1) solve(r-1,c);
        if(c+1 < m && grid[r][c+1] != -1) solve(r,c+1);
        if(c-1 >= 0 && grid[r][c-1] != -1) solve(r,c-1);

        grid[r][c] = 0;
        count--;
    }
}