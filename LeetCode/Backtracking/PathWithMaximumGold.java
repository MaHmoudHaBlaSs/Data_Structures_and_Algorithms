// https://leetcode.com/problems/path-with-maximum-gold/description/

class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfsGold(grid, visited, i, j));
                }
            }
        }
        return maxGold;
    }
    public int dfsGold(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        // DO
        visited[r][c] = true;
        int gold = grid[r][c];

        // RECURSE
        int maxGoldFromHere = 0;
        maxGoldFromHere = Math.max(maxGoldFromHere, dfsGold(grid, visited, r - 1, c));
        maxGoldFromHere = Math.max(maxGoldFromHere, dfsGold(grid, visited, r + 1, c));
        maxGoldFromHere = Math.max(maxGoldFromHere, dfsGold(grid, visited, r, c - 1));
        maxGoldFromHere = Math.max(maxGoldFromHere, dfsGold(grid, visited, r, c + 1));

        // UNDO
        visited[r][c] = false;
        
        return gold + maxGoldFromHere;
    }
}