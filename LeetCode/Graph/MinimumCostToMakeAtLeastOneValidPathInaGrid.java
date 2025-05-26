///  https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description

class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length; 
        int[][] dist = new int [n][m];
        for(int i=0; i<n; i++) Arrays.fill(dist[i], 0x3f3f3f3f); 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[] {0,0,0});

        while(!pq.isEmpty()){
            int[] source = pq.poll();
            int i = source[0], j = source[1], weight = source[2];
            
            if (i == n - 1 && j == m - 1) return weight;
            if(weight >= dist[i][j]) continue;

            dist[i][j] = weight;  
            if(j + 1 < m && dist[i][j+1] > weight + (grid[i][j] == 1 ? 0 : 1))   
                pq.add(new int[] {i,j+1, weight + (grid[i][j] == 1 ? 0 : 1)});

            if(j - 1 >= 0 && dist[i][j-1] > weight + (grid[i][j] == 2 ? 0 : 1))   
                pq.add(new int[] {i,j-1, weight + (grid[i][j] == 2 ? 0 : 1)});

            if(i + 1 < n && dist[i+1][j] > weight + (grid[i][j] == 3 ? 0 : 1))   
                pq.add(new int[] {i+1,j, weight + (grid[i][j] == 3 ? 0 : 1)});

            if(i - 1 >= 0 && dist[i-1][j] > weight + (grid[i][j] == 4 ? 0 : 1))   
                pq.add(new int[] {i-1,j, weight + (grid[i][j] == 4 ? 0 : 1)});
        }

        return dist[n-1][m-1];
    }
}