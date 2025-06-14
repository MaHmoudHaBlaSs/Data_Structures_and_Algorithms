/// https://leetcode.com/problems/01-matrix/description/?

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            
            for(int[] d : dirs){
                int nx = x + d[0], ny = y + d[1];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]){
                    dist[nx][ny] = dist[x][y] + 1;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }
}
