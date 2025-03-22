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