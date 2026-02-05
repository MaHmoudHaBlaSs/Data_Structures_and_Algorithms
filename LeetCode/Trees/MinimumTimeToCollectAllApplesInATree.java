///  https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>(3);
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        return dfs(0, -1, tree, hasApple);
    }

    private int dfs(int v, int p, ArrayList<Integer>[] tree, List<Boolean> hasApple){
        int ans = 0;

        for(int u : tree[v]){
            if(u != p){
                int time =  dfs(u, v, tree, hasApple);

                if(time > 0 || hasApple.get(u)) ans += 2 + time;
            }
        }
        
        return ans;
    }
}