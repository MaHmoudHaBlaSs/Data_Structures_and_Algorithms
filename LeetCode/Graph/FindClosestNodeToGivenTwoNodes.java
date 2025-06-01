/// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/

class Solution {
    private final int oo = 0x3f3f3f3f;
    private int[] edges;
    private boolean[] vis;

    private void DFS(int u, int depth, int[] dist){
        vis[u] = true;
        dist[u] = depth;

        if(edges[u] != -1 && !vis[edges[u]]) DFS(edges[u], depth+1, dist);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = new int[edges.length], dist2 = new int[edges.length];
        vis = new boolean[edges.length];
        this.edges = edges;
        Arrays.fill(dist1, oo);
        Arrays.fill(dist2, oo);

        DFS(node1, 0, dist1);
        Arrays.fill(vis, false);
        DFS(node2, 0, dist2);

        int minDist = oo, ans = -1;
        for(int i=0; i<dist1.length; i++){
            if(dist1[i] == oo || dist2[i] == oo) continue; //not reachable form both sources
            
            int maxDist = Math.max(dist1[i], dist2[i]);
            if(minDist > maxDist || (minDist == maxDist && i < ans)) {
                minDist =  maxDist;
                ans = i;
            } 
        }

        return ans ;
    }
}