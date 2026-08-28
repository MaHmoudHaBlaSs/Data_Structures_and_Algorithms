///  https://leetcode.com/problems/parallel-courses-iii/description/

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; ++i){
            adj[i] = new ArrayList<>();
        }

        for(int[] e : relations){
            adj[e[1]-1].add(e[0]-1);
        }

        int[] arr = new int[n];
        int ans = 0;
        for(int i=0; i<n; ++i){
            ans = Integer.max(ans, dfs(i, adj, arr, time));
        }

        return ans;
    }

    private int dfs(int u, ArrayList<Integer>[] adj, int[] arr, int[] time){
        if(arr[u] != 0) return arr[u];

        int ans = 0;
        for(int neb : adj[u]){
            ans = Integer.max(ans, dfs(neb, adj, arr, time));
        }

        ans += time[u];
        return arr[u] = ans;
    }
}
