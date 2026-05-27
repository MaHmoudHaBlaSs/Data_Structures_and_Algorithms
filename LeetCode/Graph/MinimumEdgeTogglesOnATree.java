///  https://leetcode.com/problems/minimum-edge-toggles-on-a-tree/description/

class Solution {
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        boolean[] st = new boolean[n], tar = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            st[i] = start.charAt(i) == '1';
            tar[i] = target.charAt(i) == '1';
        }

        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(i);
            adj[edges[i][1]].add(i);
        }

        HashSet<Integer> ans = new HashSet<>();
        boolean[] visited = new boolean[n];
        
        dfs(0, -1, adj, edges, ans, visited, st, tar);
        
        if(ans.contains(-1)) return List.of(-1);
        
        return ans.stream().sorted().toList();
    }

    private void dfs(int v, int parentEdge, ArrayList<Integer>[] adj, int[][] edges,  HashSet<Integer> ans, boolean[] visited, boolean[] curr, boolean[] target){
        visited[v] = true;
        
        for(int idx : adj[v]){
            int neb = edges[idx][0] == v ? edges[idx][1] : edges[idx][0];

            if(!visited[neb]){
                dfs(neb, idx, adj, edges, ans, visited, curr, target);
                
                if(ans.contains(idx)) curr[v] = !curr[v];
            }
        }
        
        if(curr[v] != target[v]) ans.add(parentEdge);
    }

}
