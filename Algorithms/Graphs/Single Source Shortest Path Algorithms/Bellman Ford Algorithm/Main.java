import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int nodes = 9;
        // You can make your own test cases and check for negative cycle, it works 😉
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 4),
                new Edge(1, 0, 4),
                new Edge(0, 7, 8),
                new Edge(7, 0, 8),
                new Edge(1, 2, 8),
                new Edge(2, 1, 8),
                new Edge(1, 7, 11),
                new Edge(7, 1, 11),
                new Edge(2, 3, 7),
                new Edge(3, 2, 7),
                new Edge(2, 8, 2),
                new Edge(8, 2, 2),
                new Edge(2, 5, 4),
                new Edge(5, 2, 4),
                new Edge(3, 4, 9),
                new Edge(4, 3, 9),
                new Edge(3, 5, 14),
                new Edge(5, 3, 14),
                new Edge(4, 5, 10),
                new Edge(5, 4, 10),
                new Edge(5, 6, 2),
                new Edge(6, 5, 2),
                new Edge(6, 7, 1),
                new Edge(7, 6, 1),
                new Edge(6, 8, 6),
                new Edge(8, 6, 6),
                new Edge(7, 8, 7),
                new Edge(8, 7, 7)
        );
        int[] parents = applyBellmanFord(edges, 0, 9);
        for (int target = 1; target < nodes; target++) {
            List<Integer> path = getPath(target, parents);
            for (Integer node: path)
                System.out.print(node+" -> ");
            System.out.println("\b\b\b");
        }
    }

    public static int[] applyBellmanFord(List<Edge> edges, int source, int n){
        int sweeps = 0;
        boolean isUpdated = true;
        int[] costs = new int[n];
        int[] parents = new int[n];

        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[source] = 0;
        parents[source] = -1;

        while (isUpdated){ // While changes happen
            isUpdated = false;
            if (sweeps > n-1){
                System.out.println("Negative Cycle Found!!");
                return new int[]{};
            }
            for (Edge edge: edges){
                if (costs[edge.source] + edge.weight < costs[edge.target]) {
                    costs[edge.target] = costs[edge.source] + edge.weight;
                    parents[edge.target] = edge.source;
                    isUpdated = true;
                }
            }
            sweeps++;
        }
        return parents;
    }

    public static List<Integer> getPath(int target, int[] parents){
        List<Integer> path = new LinkedList<>();
        int back = target;
        while (back != -1){
            path.add(back);
            back = parents[back];
        }
        Collections.reverse(path);
        return path;
    }
}