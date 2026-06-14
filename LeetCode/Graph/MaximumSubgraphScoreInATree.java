///   https://leetcode.com/problems/maximum-subgraph-score-in-a-tree/description/


class Solution {
    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        int[] dp =  new int[n];
        dfs(0, 0, adj, dp, good);
        reroot(0, 0, adj, dp);
        
        return dp;
    }
    
    private int dfs(int u, int parent, ArrayList<Integer>[] adj, int[] dp, int[] good){
        int ans = good[u] == 1 ? 1 : -1;
        
        for(int v : adj[u]){
            if(v != parent){
                int sub = dfs(v, u, adj, dp, good);
                
                if(sub > 0) ans += sub;
            }
        }
        
        return dp[u] = ans;
    }
    
    private void reroot(int u, int parent, ArrayList<Integer>[] adj, int[] dp){
        
        if(dp[parent] > dp[u]){
            dp[u] += dp[parent] - (dp[u] <= 0? 0 : dp[u]);
        }
 
        for(int v : adj[u]){
            if(v != parent){
                reroot(v, u, adj, dp);
            }
        }
    }

}