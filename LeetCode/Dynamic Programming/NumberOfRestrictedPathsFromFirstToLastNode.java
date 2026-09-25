// https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    private final int MOD = 1_000_000_000 + 7;
    private List<List<int[]>> graph;
    private int n;
    private int[] costs;
    private int[] dp;

    public int countRestrictedPaths(int nodes, int[][] edges) {
        n = nodes;
        graph = new ArrayList<>(n+1);

        for (int i = 0; i <= n; i++)
            graph.add(new LinkedList<>());
        
        for (int[] edge: edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // 1. Get minimum costs array using dijkstra
        costs = shortestPaths();

        // 2. apply DFS with DP to count restricted paths from 1 to n
        dp = new int[n+1];
        Arrays.fill(dp, -1); 
        dp[n] = 1;
        return dfs(1);
    }

    private int dfs(int i){
        if ( dp[i] != -1) return dp[i];

        dp[i] = 0;

        for ( int[] node: graph.get(i) ) {
            if ( costs[i] > costs[node[0]] )
                dp[i] = (dp[i] + dfs(node[0])) % MOD;
        }
        return dp[i];
    }

    private int[] shortestPaths(){
        int[] costs = new int[n+1];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.add(new int[]{n, 0});

        while (!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();

            if (costs[polled[0]] == 0){
                costs[polled[0]] = polled[1];
                for ( int[] neighbor: graph.get(polled[0])){
                    if (neighbor[0] != n && costs[neighbor[0]] == 0)
                        minHeap.add(new int[]{neighbor[0], neighbor[1] + polled[1]});
                }
            }
        }

        return costs;
    }
}