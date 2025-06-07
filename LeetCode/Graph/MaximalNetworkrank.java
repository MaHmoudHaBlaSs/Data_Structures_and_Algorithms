///  https://leetcode.com/problems/maximal-network-rank/description/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] adj = new Set[n];
        for(int i=0; i<n;i++) adj[i] = new HashSet<>();

        for(var road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }

        int ans = 0;
        for(int i=0; i<n-1;i++){
            for(int j=i+1; j<n; j++){
                ans = Math.max(ans, adj[i].size() + adj[j].size() - (adj[i].contains(j) ? 1 : 0) );
            }
        }
        
        return ans;
    }
}