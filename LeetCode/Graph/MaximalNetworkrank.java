///  https://leetcode.com/problems/maximal-network-rank/description/

// T: O(n^2)        S: O(n^2)
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

// Another Implementation with The Same Idea
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] cities = new int[n];
        
        for (int[] road: roads){
            cities[road[0]]++;
            cities[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++)
                max = Math.max(max, cities[i] + cities[j] + (connected[i][j]?-1:0));
        }
        return max;
    }
}