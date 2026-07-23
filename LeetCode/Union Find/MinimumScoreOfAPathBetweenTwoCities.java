///  https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/

class Solution {
    public int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n+1);

        for(int[] road : roads){
            uf.union(road[0], road[1]);
        }

        int ans = 1_000_00;
        int root = uf.find(1);

        for(int[] road : roads){
            if(root == uf.find(road[0])){
                if(ans > road[2])
                    ans = road[2];
            }
        }        

        return ans;
    }

    public static class UnionFind{
        private int[] parent;

        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int u){
            if(parent[u] == u)
                return u;

            return parent[u] = find(parent[u]);
        }

        public boolean union(int u, int v){
            int uParent = find(u), vParent = find(v);

            if(uParent == vParent){
                return false;
            }

            parent[uParent] = vParent;
            return true;
        }
    } 
}