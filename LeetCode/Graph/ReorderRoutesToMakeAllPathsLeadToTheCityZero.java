///  https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/


class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<Integer>[] primary =  new ArrayList[n], secondary = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            primary[i] = new ArrayList<>();
            secondary[i] = new ArrayList<>();
        }
        
        for (int[] connection : connections) {
            primary[connection[0]].add(connection[1]);
            secondary[connection[1]].add(connection[0]);
        }
        
        return dfs(0, new boolean[n], primary, secondary);
    }

    private int dfs(int u, boolean[] vis, ArrayList<Integer>[] primary,  ArrayList<Integer>[] secondary) {
        vis[u] = true;
        int ans = 0; 
        
        for (int v : primary[u]) {
            if (!vis[v]) {
                ans += dfs(v, vis, primary, secondary)+1;
            }
        }
        
        for (int v : secondary[u]) {
            if (!vis[v]) {
                ans += dfs(v, vis, primary, secondary);
            }
        }
        
        return ans;
    }
}
