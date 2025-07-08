///  https://leetcode.com/problems/count-sub-islands/description/

class Solution {
    private int n,m;
    
    private boolean isMatch(int i,int j,int[][] grid1, int[][] grid2){
        boolean answer = grid1[i][j] == grid2[i][j];
        grid2[i][j] = 0;

        if(i-1 >= 0 && grid2[i-1][j] == 1) 
            answer &= isMatch(i-1, j, grid1, grid2); 
        if(i+1 < n && grid2[i+1][j] == 1) 
            answer &= isMatch(i+1, j, grid1, grid2); 

        if(j-1 >= 0 && grid2[i][j-1] == 1) 
            answer &= isMatch(i, j-1, grid1, grid2); 
        if(j+1 < m && grid2[i][j+1] == 1) 
            answer &= isMatch(i, j+1, grid1, grid2); 

        return answer;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length; m = grid1[0].length;
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid2[i][j] == 1 && isMatch(i,j, grid1, grid2)) 
                    count++; 
            }
        }

        return count;
    }
}