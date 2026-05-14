// https://leetcode.com/problems/maximum-path-quality-of-a-graph

class Solution {
    static class Node{

        private static class Edge{
            int to;
            int time;

            public Edge(int to, int time){
                this.to = to;
                this.time = time;
            }
        }

        int value;
        List<Edge> edges;

        public Node(int val){
            value = val;
            edges = new LinkedList<>();
        }

        public void addEdge(int to, int time){
            edges.add(new Edge(to, time));
        }
    }


    int[] visited;
    Node[] graph;
    int maxTime;
    int maxReward = 0;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime)  {
        visited = new int[values.length];
        this.maxTime = maxTime;

        graph = new Node[values.length];
        for(int i = 0; i < values.length; i++)
            graph[i] = new Node(values[i]);

        for (int[] edge: edges){
            graph[edge[0]].addEdge(edge[1], edge[2]);
            graph[edge[1]].addEdge(edge[0], edge[2]);
        }
        explore(0, graph[0].value, 0);
        return maxReward;
    }

    // Explore like a tree and don't care with looping behavior as time eventually will get exceeded
    private void explore(int node, int reward, int time){
        if (node == 0)
            maxReward = Math.max(maxReward, reward);

        visited[node]++;
        for ( Node.Edge edge: graph[node].edges ) {
            if ( time + edge.time <= maxTime){
                if ( visited[edge.to] > 0 )
                    explore(edge.to, reward, time + edge.time);
                else
                    explore(edge.to, reward + graph[edge.to].value, time + edge.time);
            }
        }
        visited[node]--;
    }
}