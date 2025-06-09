import java.util.*;

public class Main{
    public static void main( String[] args ){
        // You Must Pass U to get to V.
        // Edge >> [U -> V]
        int n = 6; // Nodes
        int[][] edgeList = new int[7][2];
        edgeList[0][0] = 2;
        edgeList[0][1] = 1;

        edgeList[1][0] = 5;
        edgeList[1][1] = 2;

        edgeList[2][0] = 5;
        edgeList[2][1] = 0;

        edgeList[3][0] = 4;
        edgeList[3][1] = 0;

        edgeList[4][0] = 4;
        edgeList[4][1] = 1;

        edgeList[5][0] = 2;
        edgeList[5][1] = 3;

        edgeList[6][0] = 3;
        edgeList[6][1] = 1;

        List<List<Integer>> graph = new ArrayList<>(n);
        int[] inDegrees = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(i, new ArrayList<>());

        for (int[] edge: edgeList){
            graph.get(edge[0]).add(edge[1]);
            inDegrees[edge[1]]++;
        }

        List<Integer> sorted = topologicalSort(n, graph, inDegrees);
        for (int num: sorted)
            System.out.print(num+" ");

    }
    
    // Kahn's Algorithm [BFS]
    public static List<Integer> topologicalSort(int n, List<List<Integer>> graph, int[] inDegrees){
        List<Integer> topoSorted = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n ;i++){
            if (inDegrees[i] == 0)
                queue.add(i);
        }

        int polls = 0;
        while (!queue.isEmpty()){
            int polled = queue.poll();
            topoSorted.add(polled);
            polls++;

            for (int neigh: graph.get(polled)) {
                inDegrees[neigh]--;
                if (inDegrees[neigh] == 0)
                    queue.add(neigh);
            }
        }
        if (polls != n){
            System.out.println("The Graph Has Cycle !! -- Isn't DAG");
            return null;
        }
        return topoSorted;
    }

}