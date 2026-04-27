///   https://leetcode.com/problems/count-the-number-of-complete-components/description/

class Solution {
    private boolean[] visited; 
    private List<Integer>[] adj;

    private void dfs(int u, List<Integer> list){
        visited[u] = true; 
        list.add(u); 

        if(adj[u] == null) return; 

        for(int v : adj[u])
            if(!visited[v]) 
                dfs(v,list); 
    }

    public int countCompleteComponents(int n, int[][] edges) {
        visited = new boolean[n];
        adj = new ArrayList[n];

        for(var edge : edges){
            if(adj[edge[0]] == null) 
                adj[edge[0]] = new ArrayList<>() ;         
            if(adj[edge[1]] == null) 
                adj[edge[1]] = new ArrayList<>() ; 

            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }                

        int ans =0;

        for(int i=0; i<n;i++){
            if(!visited[i]){
                ArrayList<Integer> comp = new ArrayList<>(); 
                dfs(i,comp); 
                boolean complete = true;
                for(int node : comp){
                    if(adj[node] != null && adj[node].size() != comp.size()-1) 
                        complete = false;
                }

                if(complete) ans++;
            }
        }

        return ans;
    }
}


class Solution {
    /**
    * The solution uses Disjoint Set Union (DSU) to group connected components.
    * For each component, we track the number of vertices (V) and edges (E).
    * A component is "complete" if its edge count equals V * (V - 1) / 2.
    */

    private int[] parent;
    private int[] size;
    private int[] edgeCount;
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        edgeCount = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1; // Each node starts as a component of size 1
        }
        for (int[] edge : edges) {
            int rootU = find(edge[0]);
            int rootV = find(edge[1]);

            if (rootU != rootV) {
                // Union logic
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
                edgeCount[rootV] += edgeCount[rootU] + 1; // Combine existing + current edge
            } else {
                // They are already in the same set, just add the edge
                edgeCount[rootU]++;
            }
        }
        int completeCount = 0;
        for(int i = 0 ; i < n; i++){
            if (parent[i] ==  i ){
                long siz = size[i];
                long edgesCount = edgeCount[i];
                if (edgesCount == siz * (siz - 1) / 2) {
                    completeCount++;
                }
            }
        }
            return  completeCount;
    }
    private int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
}