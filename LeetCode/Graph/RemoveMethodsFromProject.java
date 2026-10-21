///  https://leetcode.com/problems/remove-methods-from-project/description/

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] indegree = new int[n];
        ArrayList<Integer>[] adj = constructDirectedGraph(n, invocations);

        boolean[] suspicious = new boolean[n];
        dfs(k, adj, suspicious);


        for (int[] inv : invocations) {
            if(!suspicious[inv[0]] && suspicious[inv[1]]){
                return IntStream.range(0,n).boxed().toList();
            }
        }

        return IntStream.range(0,n).filter((num) -> !suspicious[num]).boxed().toList();
    }

    private void dfs(int v, ArrayList<Integer>[] adj, boolean[] vis){

        vis[v] = true;

        for(int neb : adj[v]){
            if(!vis[neb]){
                dfs(neb, adj, vis);
            }
        }
    }


    private ArrayList<Integer>[] constructDirectedGraph(int n, int[][] edges){
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
        }

        return adj;
    }
}