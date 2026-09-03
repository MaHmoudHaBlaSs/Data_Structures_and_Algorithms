// https://leetcode.com/problems/cyclically-rotating-a-grid/description/

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length , n = grid[0].length , layers = Math.min(m,n)/2;
        int res[][] = new int[m][n];
        for(int layerNum = 0 ; layerNum < layers ; layerNum++){
            List<Integer> layerElements = new ArrayList<>();

            for (int i = layerNum; i < n - layerNum; i++) layerElements.add(grid[layerNum][i]);
            for (int i = layerNum + 1; i < m - layerNum; i++) layerElements.add(grid[i][n - layerNum - 1]);
            for (int i = n - layerNum - 2; i >= layerNum; i--) layerElements.add(grid[m - layerNum - 1][i]);
            for (int i = m - layerNum - 2; i > layerNum; i--) layerElements.add(grid[i][layerNum]);

            int layerK = k % layerElements.size();

            rotate(layerElements, layerK);

            int idx = 0;

            for (int i = layerNum; i < n - layerNum; i++) res[layerNum][i] = layerElements.get(idx++);
            for (int i = layerNum + 1; i < m - layerNum; i++) res[i][n - layerNum - 1] = layerElements.get(idx++);
            for (int i = n - layerNum - 2; i >= layerNum; i--) res[m - layerNum - 1][i] = layerElements.get(idx++);
            for (int i = m - layerNum - 2; i > layerNum; i--) res[i][layerNum] = layerElements.get(idx++);

        }
        return res;
    }
    // Triple Reverse Algorithm
    public void rotate(List<Integer> nums, int k) {
        int n = nums.size();
        if (n == 0) return;
        k = k % n;
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }

    public void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}