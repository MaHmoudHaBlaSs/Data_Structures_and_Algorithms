///  leetcode.com/problems/minimum-time-to-visit-disappearing-nodes/description/

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<int[]>[] adj = constructWeightedGraph(n, edges);

        boolean[] vis = new boolean[n];
        int[] time = new int[n];
        Arrays.fill(time, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0], t = top[1];
            
            if(vis[node]) continue;
            
            vis[node] = true;
            time[node] = t;

            for(int[] arr : adj[node]){
                if(vis[arr[0]]) continue;
                if(disappear[arr[0]] > t + arr[1]) pq.add(new int[] {arr[0], t + arr[1]});
            }
        }
        
        return time;
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