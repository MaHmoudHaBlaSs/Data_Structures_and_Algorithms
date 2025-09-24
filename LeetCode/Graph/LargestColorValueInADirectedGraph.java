///  https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/


class Solution {
    private final char IN_PROGRESS = 'P', VISITED = 'V', UNVISITED = 'U';
    private ArrayList<Integer>[] adj;
    private int[][] dp; 
    
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        adj = new ArrayList[n];
        dp = new int[n][];
        
        for(int[] edge : edges){
            if(adj[edge[0]] == null) adj[edge[0]] = new ArrayList<>();
            adj[edge[0]].add(edge[1]);
        }
        
        char[] status = new char[n];
        Arrays.fill(status, UNVISITED);
        for (int i = 0; i < n; ++i) {
            if (status[i] == UNVISITED && isCycle(status, i))
                return -1;
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if(dp[i] == null) dp[i] = dfs(i, colors);
            
            ans = Math.max(ans, Arrays.stream(dp[i]).max().getAsInt());
        }
        
        return ans;
    }
    
    private boolean isCycle(char[] status, int node){
        if(adj[node] == null) return false;
        
        status[node] = IN_PROGRESS;
        
        for(int neighbor : adj[node]){
            if(status[neighbor] == IN_PROGRESS) return true;
            if(status[neighbor] == UNVISITED && isCycle(status, neighbor)) return true;
        }
        
        status[node] = VISITED;
        return false;
    }

    private int[] dfs(int node, String colors){
        if(dp[node] != null) return dp[node];
        
        int[] ans = new int[26];
        
        if(adj[node] != null){
            for(int neighbor : adj[node]){
                int[] next = dfs(neighbor, colors);
                for(int i = 0; i < 26; i++){
                    ans[i] = Math.max(ans[i], next[i]);
                }
            }
        }
        
        ans[colors.charAt(node) - 'a']++;
        dp[node] = ans;
        return ans;
    }
}