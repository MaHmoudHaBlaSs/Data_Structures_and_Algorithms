// https://leetcode.com/problems/design-graph-with-shortest-path-calculator

class Graph {
    List<List<int[]>> adjList;

    public Graph(int n, int[][] edges) {
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            adjList.add(i, new LinkedList<>());

        for (int[] edge : edges)
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
    }

    public void addEdge(int[] edge) {
        adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
    }

    public int shortestPath(int node1, int node2) {
        boolean[] visited = new boolean[adjList.size()];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        heap.add(new int[] { node1, 0 });

        while (!heap.isEmpty()) {
            int[] node = heap.poll();
            if (node[0] == node2)
                return node[1];

            if (visited[node[0]])
                continue;
            visited[node[0]] = true;

            for (int[] nextNode : adjList.get(node[0])) {
                if (!visited[nextNode[0]])
                    heap.add(new int[] { nextNode[0], nextNode[1] + node[1] });
            }
        }
        return -1;
    }
}