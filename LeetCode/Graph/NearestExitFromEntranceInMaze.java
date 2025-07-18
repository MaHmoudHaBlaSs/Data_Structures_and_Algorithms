/// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        int n = maze.length, m = maze[0].length; 

        int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        maze[entrance[0]][entrance[1]] = '+';

        for(int i=0; i<4; i++){
            int nr = entrance[0] + dir[i][0], nc = entrance[1] + dir[i][1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] == '.'){
                q.offer(new int[]{nr, nc});   
                maze[nr][nc] = '+';
            }
        }

        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size(); 
            
            while(--size >= 0){
                int[] cell = q.poll(); 
                if(cell[0] == 0 || cell[0] == n-1 || cell[1] == 0 || cell[1] == m-1) 
                    return steps;

                for(int i=0; i<4; i++){
                    int nr = cell[0] + dir[i][0], nc = cell[1] + dir[i][1];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] == '.'){
                        q.offer(new int[]{nr, nc});  
                        maze[nr][nc] = '+'; 
                    }
                } 
            }
 
            steps++;              
        }

        return -1;
    }
}