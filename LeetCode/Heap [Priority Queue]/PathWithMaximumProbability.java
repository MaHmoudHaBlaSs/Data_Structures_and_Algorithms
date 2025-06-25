// https://leetcode.com/problems/path-with-maximum-probability

class Solution {
    class Node implements Comparable<Node>{
        int vertex;
        double prob;

        public Node(int vertex, double prob){
            this.vertex = vertex;
            this.prob = prob;
        }

        @Override
        public int compareTo(Node other){
            return Double.compare(other.prob, this.prob);
        }
    }
    class Edge {
        int target;
        double prob;

        public Edge(int trgt, double prb){
            target = trgt;
            prob = prb;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());

        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
        }
        
        double[] probs = new double[n];
        Arrays.fill(probs, 0);
        probs[start_node] = 1;

        PriorityQueue<Node> maxHeap = new PriorityQueue<>();
        maxHeap.add(new Node(start_node, 1));

        while (!maxHeap.isEmpty()){
            Node maxNode = maxHeap.poll();

            for (Edge edge: graph.get(maxNode.vertex)){
                if (maxNode.prob * edge.prob > probs[edge.target]){
                    probs[edge.target] = maxNode.prob * edge.prob;
                    maxHeap.add(new Node(edge.target, probs[edge.target]));
                }
            }
        }
        return probs[end_node];
    }
}