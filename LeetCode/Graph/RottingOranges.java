// https://leetcode.com/problems/rotting-oranges/description


// Go Search for Multi Source BFS
// DFS won't work if we have more than 1 rotten orange which is a possible input.   
class Solution {
    // T: O(n^2)             S: O(n)
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> queue = new LinkedList<>(); // Queue of indexes
        int rows = grid.length, cols = grid[0].length;
        int time = 0, freshOranges = 0;


        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)
                    queue.add(new Integer[]{i, j});
                else if (grid[i][j] == 1) freshOranges++;
            }
        }
        

        // Perform BFS [only add rotten oranges]
        while (!queue.isEmpty() && freshOranges > 0){
            for (int i = queue.size(); i > 0; i--){
                Integer[] popped = queue.poll();

                // Available direction to spread the infection (up, right, down, left)
                Integer[][] directions = new Integer[][] {{-1, 0},{0, 1},{1, 0},{0, -1}};
                for (Integer[] dir: directions){
                    int r = dir[0]+popped[0], c = dir[1]+popped[1];
                    
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) { // Spread to fresh oranges only
                        queue.add(new Integer[]{r, c});
                        grid[r][c] = 2; // Marking as visited
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        return (freshOranges == 0)?time:-1;
    }
}