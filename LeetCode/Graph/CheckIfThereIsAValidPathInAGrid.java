/// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/description/

class Solution {
    static enum Dir{
        UP,DOWN,LEFT,RIGHT
    }
    
    public boolean hasValidPath(int[][] grid) {
        int n=grid.length, m=grid[0].length; 
        
        return hasPath(0,0,Dir.LEFT,grid, new boolean[n][m]) 
            || hasPath(0,0,Dir.UP,grid, new boolean[n][m])
            || hasPath(0,0,Dir.DOWN,grid, new boolean[n][m])
            || hasPath(0,0,Dir.RIGHT,grid, new boolean[n][m]);

    }

    private boolean hasPath(int i,int j, Dir dir, int[][] grid, boolean[][] vis){
        if(i < 0 || j<0 || i >= grid.length || j>=grid[0].length) return false;
        if(vis[i][j]) return false;

        vis[i][j] = true;
        boolean isLast = i == grid.length-1 && j==grid[0].length-1;
        int street = grid[i][j];
        
        if(dir == Dir.UP){
            if(street == 2) return isLast || hasPath(i+1,j,Dir.UP,grid,vis);
            if(street == 5) return isLast || hasPath(i,j-1,Dir.RIGHT,grid,vis);
            if(street == 6) return isLast || hasPath(i,j+1,Dir.LEFT,grid,vis);
        }else if(dir == Dir.DOWN){
            if(street == 2) return isLast || hasPath(i-1,j,Dir.DOWN,grid,vis);
            if(street == 3) return isLast || hasPath(i,j-1,Dir.RIGHT,grid,vis);
            if(street == 4) return isLast || hasPath(i,j+1,Dir.LEFT,grid,vis);            
        }else if(dir == Dir.LEFT){
            if(street == 1) return isLast || hasPath(i,j+1,Dir.LEFT,grid,vis);
            if(street == 3) return isLast || hasPath(i+1,j,Dir.UP,grid,vis);
            if(street == 5) return isLast || hasPath(i-1,j,Dir.DOWN,grid,vis);            
        }else{
            if(street == 1) return isLast || hasPath(i,j-1,Dir.RIGHT,grid,vis);
            if(street == 4) return isLast || hasPath(i+1,j,Dir.UP,grid,vis);
            if(street == 6) return isLast || hasPath(i-1,j,Dir.DOWN,grid,vis); 
        }    

        return false;    
    }
}