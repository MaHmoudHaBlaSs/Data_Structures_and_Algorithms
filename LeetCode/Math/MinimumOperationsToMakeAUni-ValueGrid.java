// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/

class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int[] nums = new int[n * m];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[k++] = grid[i][j];
            }
        }

        Arrays.sort(nums);


        // Median        
        int median = nums[nums.length / 2];
        int opCount = 0;

        for (int val : nums) {
            int diff = Math.abs(val - median);
            if (diff % x != 0) {
                return -1;
            }
            opCount += diff / x;
        }

        return opCount;
    }
}