///   https://leetcode.com/problems/shortest-bridge/

//Traverse the first island using DFS.
//While performing DFS, add all the water boundaries (i, j) where grid[i][j] = 0 of the first island to the queue.

class Solution {
    private int n;
    private int[][] grid; 

    public int shortestBridge(int[][] grid) {
        Queue<Integer> q = new LinkedList<>(); 
        n = grid.length; 
        this.grid = grid;

        for(int i=0; i<n; i++){
            boolean got = false;  
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, q);
                    got = true; 
                    break;
                }
            }
            if(got) break;
        }
        
        int ans = 0; 
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int cell = q.poll();
                int i = cell / n;
                int j = cell % n;

                if(i+1 < n ){
                    if(grid[i+1][j] == 1) return ans+1; 
                    if(grid[i+1][j] == 0){
                        grid[i+1][j] = -1;
                        q.offer(cell(i+1, j));
                    }
                } 

                if(i-1 >= 0){
                    if(grid[i-1][j] == 1) return ans+1 ;
                    if(grid[i-1][j] == 0){
                        grid[i-1][j] = -1;
                        q.offer(cell(i-1, j));
                    }
                }

                if(j+1 < n){
                    if(grid[i][j+1] == 1) return ans+1;
                    if(grid[i][j+1] == 0){
                        grid[i][j+1] = -1;
                        q.offer(cell(i, j+1));
                    }
                }

                if(j-1 >= 0){
                    if(grid[i][j-1] == 1) return ans+1;
                    if(grid[i][j-1] == 0){
                        grid[i][j-1] = -1;
                        q.offer(cell(i, j-1));
                    }
                }
            }
            ans++;
        }

        return ans;
    }


    private void dfs(int i,int j, Queue<Integer> q){
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j] == -1)
            return;

        if(grid[i][j] == 0){
            q.offer(cell(i, j));
            grid[i][j] = -1; 
            return;
        }

        grid[i][j] = -1; 
        dfs(i+1, j, q);
        dfs(i-1, j, q);
        dfs(i, j+1, q);
        dfs(i, j-1, q);
    }

    int cell(int i, int j){
        return i*n + j;
    }
}