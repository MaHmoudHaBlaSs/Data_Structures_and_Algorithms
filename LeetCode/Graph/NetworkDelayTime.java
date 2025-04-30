// https://leetcode.com/problems/network-delay-time/description/

// Optimal.
// Dijkstra's Algorithm
// T: O((N+E) * Log(E))  N >> Nodes, E >> Edges          S: O(n)
class Solution {
    class Node implements Comparable<Node>{
        int vertex;
        int cost;

        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.cost, other.cost);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>(); // int[0] = target, int[1] = cost
        int[] costs = new int[n];
        PriorityQueue<Node> minHeap = new PriorityQueue<>(); 
        
        // To apply Dijkstra we can't continue with times array we need to reform it.
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    
        // Loop on all edges
        for (int i = 0; i < times.length; i++){ 
            // before put vertexes we subtract them by 1 becuase they are 1-indexed!!
            graph.get(times[i][0]-1).add(new int[]{times[i][1]-1, times[i][2]});
        }

        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[k-1] = 0; // -1 because it's 1-indexed
        minHeap.add(new Node(k-1, 0));

        while(!minHeap.isEmpty()){
            Node current = minHeap.poll();

            // Access all node edges and try to relax them
            for (int[] edge: graph.get(current.vertex)){ 
                if(current.cost + edge[1] < costs[edge[0]]){
                    costs[edge[0]] = current.cost + edge[1];
                    minHeap.add(new Node(edge[0], costs[edge[0]]));
                }
            }
        }

        int max = 0;
        for (int cost: costs){
            if (max < cost)
                max = cost;
        }
        return (max == Integer.MAX_VALUE)? -1: max;
    }
}