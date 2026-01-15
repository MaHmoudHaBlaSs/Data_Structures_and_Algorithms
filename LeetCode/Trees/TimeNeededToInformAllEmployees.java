///  https://leetcode.com/problems/time-needed-to-inform-all-employees/description/

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            int man = manager[i];
            if(man == -1)
                continue;

            if(adj[man] == null)
                adj[man] = new ArrayList<Integer>();

            adj[man].add(i);
        }
        
        int ans = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] informedAt = new int[n];
        queue.offer(headID);
        
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int u = queue.poll();

                if(adj[u] == null) continue;
                for(int v : adj[u]){
                    queue.offer(v);
                    informedAt[v] = informedAt[u] + informTime[u];
                    ans = Math.max(ans, informedAt[v]); 
                }
            }
            
        }

        return ans;
    }
}