import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nodes = 9;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) graph.add(new ArrayList<>());

        // Creation of The Graph [appended in the folder] >> Undirected graph
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(7, 8));
        graph.get(1).add(new Edge(0, 4));
        graph.get(1).add(new Edge(2, 8));
        graph.get(1).add(new Edge(7, 11));
        graph.get(2).add(new Edge(1, 8));
        graph.get(2).add(new Edge(3, 7));
        graph.get(2).add(new Edge(5, 4));
        graph.get(2).add(new Edge(8, 2));
        graph.get(3).add(new Edge(2, 7));
        graph.get(3).add(new Edge(4, 9));
        graph.get(3).add(new Edge(5, 14));
        graph.get(4).add(new Edge(3, 9));
        graph.get(4).add(new Edge(5, 10));
        graph.get(5).add(new Edge(2, 4));
        graph.get(5).add(new Edge(3, 14));
        graph.get(5).add(new Edge(4, 10));
        graph.get(5).add(new Edge(6, 2));
        graph.get(6).add(new Edge(5, 2));
        graph.get(6).add(new Edge(7, 1));
        graph.get(6).add(new Edge(8, 6));
        graph.get(7).add(new Edge(0, 8));
        graph.get(7).add(new Edge(1, 11));
        graph.get(7).add(new Edge(6, 1));
        graph.get(7).add(new Edge(8, 7));
        graph.get(8).add(new Edge(2, 2));
        graph.get(8).add(new Edge(6, 6));
        graph.get(8).add(new Edge(7, 7));

        int[] parents = dijkstra(graph, 0); // You can change source node as you want

        System.out.println("Shortest Paths from node 0:");
        for (int target = 1; target < nodes; target++) {
            List<Integer> path = getPath(target, parents);

            for (Integer node: path)
                System.out.print(node+" -> ");
            System.out.println("\b\b\b");
        }
    }

    // The complexity come from the operation we perform on the priority queue which are poll and add 
    // so if you trigger the behaviour of both you will find out that addition is performed for each edge which takes
    // O(E Log(E)) for the whole algorithm, and deletion takes O(N Log(E)):

    // T: O((N+E) * Log(E))   N >> Nodes, E >> Edges 
    public static int[] dijkstra(List<List<Edge>> graph, int source){
        int nodes = graph.size();
        int[] costs = new int[nodes];
        int[] parents = new int[nodes]; // Will help at backtracking the paths By maintaining each node parent

        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(parents, -1); // -1 means no parent discovered
        costs[source] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(source, costs[source]));


        while (!minHeap.isEmpty()){ 
            Node minNode = minHeap.poll(); 


            for (Edge edge: graph.get(minNode.vertex)){  
                
                if(minNode.cost + edge.weight < costs[edge.target]){ // Better cost discovered [better parent]
                    costs[edge.target] = minNode.cost + edge.weight; // Edge Relaxation
                    parents[edge.target] = minNode.vertex;
                    minHeap.add(new Node(edge.target, costs[edge.target])); 
                }
            }
        }
        return parents;
    }

    // Helper method in extracting the path from parents array [based on source node you passed earlier!!]
    public static List<Integer> getPath(int target, int[] parents){
        List<Integer> path = new LinkedList<>();
        int back = target;

        while (back != -1){ // the only node having parent equal to -1 is the Source node
            path.add(back);
            back = parents[back];
        }
        Collections.reverse(path);
        return path;
    }
}