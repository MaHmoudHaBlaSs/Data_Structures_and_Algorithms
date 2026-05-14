// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int stepsCount = 0 ;
        if (grid[0][0] != 0 ) return -1;
        Queue<Integer[]>  queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new Integer[]{0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                
                Integer[] current = queue.poll();
                
                if (current[0] == grid.length - 1 && current[1] == grid[0].length - 1) return stepsCount + 1;
                
                Integer[][] directions = new Integer[][]{
                    {-1, -1}, {-1, 0}, {-1, 1}, {0, 1},
                    {1, 1}, {1, 0}, {1, -1}, {0, -1}
                };

                for (Integer[] dir : directions) {
                    
                    int r = dir[0] + current[0], c = dir[1] + current[1];
                    
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 0 && !visited[r][c]) {
                        queue.offer(new Integer[]{r, c});
                        visited[r][c] = true;
                    }
                } 
            }
            stepsCount++;
        }
        return -1;
    }
}