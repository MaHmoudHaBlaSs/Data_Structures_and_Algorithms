/// https://leetcode.com/problems/max-increase-to-keep-city-skyline/

//Time: O(n^2)                Space: O(n)
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxInRow = new int[grid[0].length]; 
        int[] maxInCol = new int[grid.length]; 
    
        for(int r=0; r<grid.length;r++){
            for(int c=0;c<grid[0].length; c++){
                if(grid[r][c] > maxInRow[r]) 
                    maxInRow[r] = grid[r][c]; 

                if(grid[r][c] > maxInCol[c]) 
                    maxInCol[c] = grid[r][c]; 
            }
        }

        int ans = 0; 
        for(int r=0; r<grid.length;r++){
            for(int c=0;c<grid[0].length; c++){
                ans += Math.min(maxInRow[r], maxInCol[c]) - grid[r][c];
            }
        }        

        return ans; 
    }
}