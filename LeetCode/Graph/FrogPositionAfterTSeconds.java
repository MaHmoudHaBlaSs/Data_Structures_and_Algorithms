/// https://leetcode.com/problems/frog-position-after-t-seconds/description/

class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(n == 1) return 1;
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        
        for(int i=0; i<=n; ++i) adj[i] = new ArrayList<>();  

        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        adj[1].add(0);

        int[] parents = getParents(adj);     
        int levels = t,  targetCopy = target;
        double ans = 1;

        while(parents[target] != -1){
            target = parents[target];
            ans *= adj[target].size()-1;
            levels--;
        }
        
        if(levels < 0 || (levels > 0 && adj[targetCopy].size() > 1)) return 0;

        return 1.d/ans ;
    }

    private int[] getParents(ArrayList<Integer>[] adj){
        int[] parents = new int[adj.length];
        Arrays.fill(parents, -1);

        boolean[] visited = new boolean[adj.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int v = queue.poll();

            if(adj[v] == null) continue;

            for(int u : adj[v]){
                if(!visited[u]){
                    parents[u] = v;
                    queue.offer(u);
                    visited[u] = true;
                }
            }
        }
        parents[1] = -1; 
        return parents;
    }
}