// https://leetcode.com/problems/maximum-sum-of-an-hourglass

// T: O(n)          S: O(1)
class Solution {
    // T: O(n)
    public int maxSum(int[][] grid) {
        int max = 0;
        for (int i = 1; i < grid.length-1; i++){
            for (int j = 1; j < grid[0].length-1; j++){
                max = Math.max(max, sumOfHourGlass(grid, i, j));
            }
        }
        return max;
    }
    // T: O(1)
    public int sumOfHourGlass(int[][] grid, int x, int y){
        int sum = 0;
        for (int i = x-1; i <= x+1; i++){
            for (int j = y-1; j <= y+1; j++){
                if (i == x && j != y) continue;
                sum += grid[i][j];
            }
        }
        return sum;
    }
}