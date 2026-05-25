// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description

// Union-Find (Fastest)

class Solution {
    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for (int i = 1; i < n; i++)
                parent[i] = Integer.MIN_VALUE;
        }

        public int find(int x){

            if ( parent[x] >= 0 )
                return parent[x] = find(parent[x]); // Path Compression

            return x;
        }

        public void union(int x, int y, int roadScore) {
            int xRoot = find(x);
            int yRoot = find(y);

            int newScore = Math.max( Math.max(parent[xRoot], parent[yRoot]), roadScore * -1 );

            if (xRoot == yRoot) {
                parent[xRoot] = newScore;
                return;
            }

            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
                parent[xRoot] = newScore;

            } else if (rank[yRoot] > rank[xRoot]){
                parent[xRoot] = yRoot;
                parent[yRoot] = newScore;

            }
            else{
                parent[yRoot] = xRoot;
                parent[xRoot] = newScore;
                rank[xRoot]++;
                
            }
        }
        
        public int getRes(int n){
            return parent[find(n)] * -1;
        }
    }

    public int minScore(int n, int[][] roads) {
        UnionFind disjSets = new UnionFind(n+1);

        for (int[] road: roads)
            disjSets.union(road[0], road[1], road[2]);

        return disjSets.getRes(n);
    }
}

// Normal BFS (Slow)

class Solution {
    
    public int minScore(int n, int[][] roads) {
        int res = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n+1];
        List<List<int[]>> graph = new ArrayList<>(n+1);

        for (int i = 0; i <= n; i++)
            graph.add(new LinkedList<>());

        for (int[] road: roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        Queue<Integer> queue = new LinkedList<>(List.of(1));
        visited[1] = true;

        while ( !queue.isEmpty() ){
            int polled = queue.poll();

            List<int[]> polledRoads = graph.get(polled);

            for ( int[] road: polledRoads ){
                res = Math.min(res, road[1]);
                
                if ( !visited[road[0]]){
                    queue.add(road[0]);
                    visited[road[0]] = true;
                }
            }
        }
        return res;
    }
}