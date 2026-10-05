///  https://leetcode.com/problems/find-edges-in-shortest-paths/description/

class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        ArrayList<int[]>[] adj = constructWeightedGraph(n, edges);
        
        int[] distFromZero = dijkstra(0, n, adj);
        int[] distFromN = dijkstra(n-1, n, adj);
        int target = distFromZero[n-1];
        
        boolean[] ans = new boolean[edges.length];
        if(target == -1) return ans;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            
            if(distFromZero[u] == -1 || distFromN[u] == -1 || distFromZero[v] == -1 || distFromN[v] == -1) 
                continue;
                            
            if(distFromZero[u] + distFromN[v] + w == target || distFromN[u] + distFromZero[v] + w == target)
                ans[i] = true;
        }
        
        return ans;
    }

    private int[] dijkstra(int start, int n, ArrayList<int[]>[] adj){
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int[] neb : adj[start]) pq.add(new int[]{neb[0], neb[1]});
        
        while (!pq.isEmpty()){
            int[] top = pq.poll();
            int v = top[0], w = top[1];
            
            if(dist[v] != -1 && w >= dist[v]) continue;
            
            dist[v] = w;
            for(int[] neb : adj[v]){
                if(dist[neb[0]] == -1){
                    pq.add(new int[] {neb[0], neb[1] + w});
                }
            }
        }
        
        return dist;
    }


    private ArrayList<int[]>[] constructWeightedGraph(int n, int[][] edges){
        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        return adj;
    }

}