///  https://leetcode.com/problems/find-subtree-sizes-after-changes/description/


class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>(); 
        int n = parent.length; 

        for(int i=1; i<n; ++i){
            var list = adj.computeIfAbsent(parent[i],(k) -> new ArrayList<>());
            list.add(i);
        }

        int[] occ = new int[26]; 
        Arrays.fill(occ, -1);
        int[] ans = new int[n];
        dfs(0, adj, s, occ, ans);

        return ans;
    }

    private boolean dfs(int u, HashMap<Integer, List<Integer>> adj, String s, int[] occ, int[] ans){

        char c = s.charAt(u);
        int size = 0, prev = occ[c-'a'];
        

        occ[c-'a'] = u;

        if(adj.containsKey(u)){
            for(int neb : adj.get(u)){
                if(dfs(neb, adj, s, occ, ans)){
                    size += ans[neb];
                }
            }
        }

        ans[u] += size+1;
        occ[c-'a'] = prev;

        if(prev != -1){
            ans[prev] += ans[u];
            return false;
        }

        return true;
    }
}