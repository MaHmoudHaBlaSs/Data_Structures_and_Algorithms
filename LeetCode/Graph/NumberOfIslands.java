// https://leetcode.com/problems/number-of-islands/description

// Optimal.
// T: O(n) >> no cell is visited more than twice
// S: O(n) >> Recursion
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    discover(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    // DFS Solution
    // T: O(n)
    public void discover(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0'; // Convert 1 to 0 as marked as visited [instead of using set and costs O(n) space]

        discover(grid, i, j+1);
        discover(grid, i, j-1);
        discover(grid, i+1, j);
        discover(grid, i-1, j);
    }
}