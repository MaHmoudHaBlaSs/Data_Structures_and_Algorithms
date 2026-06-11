// https://leetcode.com/problems/map-of-highest-peak/description

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;

        int[][] heights = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (isWater[i][j] == 1){
                    visited[i][j] = true;
                    queue.addAll(getSides(i, j, heights.length, heights[0].length));
                }
            }
        }

        while ( !queue.isEmpty() ){
            int[] polled = queue.poll();
            if ( visited[polled[0]][polled[1]] )
                continue;

            visited[polled[0]][polled[1]] = true;
            List<int[]> sides = getSides(polled[0], polled[1], heights.length, heights[0].length);

            int minSide = Integer.MAX_VALUE;
            for ( int[] side: sides) {
                if ( visited[side[0]][side[1]] )
                    minSide = Math.min(minSide, heights[side[0]][side[1]]);
                else
                    queue.add(side);
            }
            
            heights[polled[0]][polled[1]] = minSide + 1;
        }
        
        return heights;
    }

    public List<int[]> getSides(int i, int j, int n, int m){
        List<int[]> available = new LinkedList<>();

        if ( isValid(i+1, j, n, m))
            available.add(new int[]{i+1, j});
        if ( isValid(i-1, j, n, m))
            available.add(new int[]{i-1, j});
        if ( isValid(i, j+1, n, m))
            available.add(new int[]{i, j+1});
        if ( isValid(i, j-1, n, m))
            available.add(new int[]{i, j-1});

        return available;
    }

    private boolean isValid(int i, int j, int n, int m ){
        return !( i < 0 || j < 0 || i >= n || j >= m );
    }
}