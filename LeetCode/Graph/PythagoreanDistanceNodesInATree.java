///  https://leetcode.com/problems/pythagorean-distance-nodes-in-a-tree/description/

class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] xDistance = distanceToAllNodes(x, adj), yDistance = distanceToAllNodes(y, adj),
                zDistance = distanceToAllNodes(z, adj);

        int ans = 0;
        for (int i = 0; i <n; i++) {
            int[] arr = new int[]{xDistance[i], yDistance[i], zDistance[i]};
            Arrays.sort(arr);
            
            if(arr[2]*arr[2] == (arr[0]*arr[0]) + (arr[1]*arr[1])) 
                ans++;
        }
        
        return ans;
    }

    private int[] distanceToAllNodes(int src, ArrayList<Integer>[] adj){
        boolean[] vis = new boolean[adj.length];
        int[] dist = new int[adj.length];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(src);
        vis[src] = true;

        while (!queue.isEmpty()){
            int v = queue.poll();
            int nextDist = dist[v]+1;

            for(int u : adj[v]){
                if(!vis[u]){
                    vis[u] = true;
                    dist[u] = nextDist;
                    queue.push(u);
                }
            }
        }

        return dist;
    }

}