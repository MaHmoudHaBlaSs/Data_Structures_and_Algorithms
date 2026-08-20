// https://leetcode.com/problems/fill-a-special-grid/description/


class Solution {
    public int[][] specialGrid(int n) {
        int dim = Math.powExact(2,n);
        int res[][] = new int[dim][dim];
        fillGrid(res, 0, 0, dim, 0);
        return res;

    }
    private void fillGrid(int[][] grid, int row, int col, int size, int startVal) {
        if (size == 1) {
            grid[row][col] = startVal;
            return;
        }

        int halfSize = size / 2;
        int blockSize = halfSize * halfSize;

        // From pattern of the examples
        // we should follow seq (top right , bottom right , bottom left , top left)
        fillGrid(grid, row, col + halfSize, halfSize, startVal); // Top right 
        fillGrid(grid, row + halfSize, col + halfSize, halfSize, startVal + blockSize); // Bottom right
        fillGrid(grid, row + halfSize, col, halfSize, startVal + 2 * blockSize); // Bottom left 
        fillGrid(grid, row, col, halfSize, startVal + 3 * blockSize); // Top left 
    }
    

}