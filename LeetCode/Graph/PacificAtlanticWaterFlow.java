// https://leetcode.com/problems/pacific-atlantic-water-flow/

// Problem Visualization: https://editor.p5js.org/LeweyM/full/RpAxMlZL4
class Solution {
    // Solution 1 [DFS] >> Optimal.
    // T: O(n)              S: O(n)
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> flows = new LinkedList<>();
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacif = new boolean[rows][cols];
        boolean[][] atlant = new boolean[rows][cols];

        for (int j = 0; j < cols; j++){ // Columns Invation
            dfs(heights, pacif, 0, j);
            dfs(heights, atlant, rows-1, j);
        }
        for (int i = 0; i < rows; i++){ // Rows Invation
            dfs(heights, pacif, i, 0);
            dfs(heights, atlant,i, cols-1);
        }

        for (int i = 0; i < heights.length; i++){
            for (int j = 0; j < heights[0].length; j++){
                if (pacif[i][j] && atlant[i][j])
                    flows.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return flows;
    }
    public void dfs(int[][] heights, boolean[][] ocean, int i, int j){
        ocean[i][j] = true;

        for (int[] dir: directions){
            int newI = i+dir[0], newJ = j+dir[1];
            if (newI < 0 || newI >= heights.length || newJ < 0 || newJ >= heights[0].length) continue;
            if (!ocean[newI][newJ] && heights[newI][newJ] >= heights[i][j])
                dfs(heights, ocean, newI, newJ);
        }
    }
    // Solution 2 [DFS]
    // T: O(n^2)         S: O(n)
    boolean reachAtlan = false, reachPacif = false;
    Set<Integer> visited = new HashSet<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> flows = new LinkedList<>();

        for (int i = 0; i < heights.length; i++){
            for (int j = 0; j < heights[0].length; j++){
                reachAtlan = false; reachPacif = false;
                visited.clear();
                dfs(heights, i, j);
                if (reachAtlan && reachPacif)
                    flows.add(new ArrayList<>(Arrays.asList(i, j)));       
            }
        }
        return flows;
    }
    public void dfs(int[][] heights, int r, int c){
        visited.add(r*heights[0].length + c);
        if (r == 0 || c == 0) reachPacif = true;
        if (r == heights.length-1 || c == heights[0].length-1) reachAtlan = true;
        if (reachAtlan && reachPacif) return;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] dir: directions){
            int i = r+dir[0], j = c+dir[1];
            if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) continue;
            if (!visited.contains(i*heights[0].length + j) && heights[i][j] <= heights[r][c])
                dfs(heights, i, j);
        }
    }
}