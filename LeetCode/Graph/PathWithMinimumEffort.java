///   https://leetcode.com/problems/path-with-minimum-effort/description/

class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private int n, m;

    public int minimumEffortPath(int[][] heights) {
        n = heights.length; m = heights[0].length;

        int left = 0, right = 1_000_000, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[n][m];
            
            if (canGetTheEnd(0, 0, heights, visited, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canGetTheEnd(int i, int j, int[][] heights, boolean[][] visited, int maxEffort) {
        if (i == n - 1 && j == m - 1) return true;
        visited[i][j] = true;

        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj] && 
                Math.abs(heights[i][j] - heights[ni][nj]) <= maxEffort && canGetTheEnd(ni, nj, heights, visited, maxEffort)) {
                return true;
            }
        }
        
        return false;
    }
}
