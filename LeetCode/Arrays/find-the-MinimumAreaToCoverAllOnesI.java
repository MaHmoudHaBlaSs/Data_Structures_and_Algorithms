/// https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/

class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;   
        int left = m,right = -1, top = n, down = -1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0) continue;

                if(i < top) top = i;
                if(i > down) down = i;
                if(j < left) left = j;
                if(j > right) right = j;
            }
        } 

        if(right == -1) return 0;
        
        return (right-left+1) * (down-top+1); 
    }
}