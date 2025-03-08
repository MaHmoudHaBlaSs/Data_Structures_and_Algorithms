///  https://leetcode.com/problems/keys-and-rooms/
class Solution {
    private boolean[] visited; 
    private List<List<Integer>> adj;

    private void dfs(int u){
        visited[u] = true; 

        for(int v : adj.get(u))
            if(!visited[v]) 
                dfs(v); 
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        adj = rooms;

        //O(n)
        dfs(0);

        for(int i=0; i<n; i++)
            if(!visited[i]) return false;

        return true; 
    }
}