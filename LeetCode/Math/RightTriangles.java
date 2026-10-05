///  https://leetcode.com/problems/right-triangles/description/

class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[] rowCount = new int[rows], colCount = new int[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    rowCount[r]++;
                    colCount[c]++;
                }
            }
        }

        long ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    ans += (long) (rowCount[r] - 1) * (colCount[c] - 1);
                }
            }
        }

        return ans;
    }
}
