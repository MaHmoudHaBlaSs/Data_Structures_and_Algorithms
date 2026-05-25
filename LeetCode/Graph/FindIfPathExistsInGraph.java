// https://leetcode.com/problems/find-if-path-exists-in-graph

class Solution {
    boolean[] visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        // Graph is represented by ArrayList not LinkedList (big difference)
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());

        for ( int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>(List.of(source));
        visited[source] = true;

        while (!queue.isEmpty()){
            int polled = queue.poll();

            if ( polled == destination )
                return true;

            for ( int v: graph.get(polled))
                if ( !visited[v] ){
                    queue.add(v);
                    visited[v] = true;
                }
        }
        return false;
    }
}