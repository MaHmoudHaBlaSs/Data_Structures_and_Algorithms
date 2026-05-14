// https://leetcode.com/problems/is-graph-bipartite/

class Solution {
     
    // Given Adjacency List Graph
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] coloredGraph = new boolean[graph.length];

        Queue<Integer> queue = new LinkedList<>(List.of(0));
        visited[0] = true;
        boolean color = true;

        while (!queue.isEmpty()) {
            color = !color;

            for (int i = queue.size(); i > 0; i--){
                int popped = queue.poll();
                coloredGraph[popped] = color;

                for (int node: graph[popped]){
                    if (!visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                    }
                }
            }

            if (queue.isEmpty()){
                for (int i = 0; i < visited.length; i++){
                    if (!visited[i]){
                        queue.add(i);
                        visited[i] = true;
                        break;
                    }
                }
            }
        }

        for (int u = 0; u < graph.length; u++){
            for (int v: graph[u]){
                if (coloredGraph[u] == coloredGraph[v])
                    return false;
            }
        }
        return true;
    }
}