///  https://leetcode.com/problems/keys-and-rooms/


// T: O(n) >> set ensures that we visit n times at most.          S: O(n)
// Implementation 1 >> More Readable and Efficient.
class Solution {
    Set<Integer> visited = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(0, rooms);    
        return (visited.size() == rooms.size())?true : false;
    }
    public void dfs(int i, List<List<Integer>> rooms){
        if (visited.contains(i)) return; // Base Case

        visited.add(i);
        for (int key = 0; key < rooms.get(i).size(); key++)
            dfs(rooms.get(i).get(key), rooms);
    }
}

// Implementation 2
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