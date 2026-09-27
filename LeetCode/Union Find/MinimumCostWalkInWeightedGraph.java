///  https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/description/

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }


        int[] componentMask = new int[n];
        Arrays.fill(componentMask, -1);

        for (int[] edge : edges) {
            int root = uf.find(edge[0]);
            componentMask[root] &= edge[2];
        }


        int[] ans = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            int u = query[i][0];
            int v = query[i][1];

            int rootU = uf.find(u);
            int rootV = uf.find(v);

            if (rootU != rootV) {
                ans[i] = -1;
            } else {
                ans[i] = componentMask[rootU];
            }
        }

        return ans;
    }

    static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (p == parent[p]) return p;

            parent[p] = find(parent[p]);
            return parent[p];
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return false;

            parent[rootP] = rootQ;
            return true;
        }
    }
}