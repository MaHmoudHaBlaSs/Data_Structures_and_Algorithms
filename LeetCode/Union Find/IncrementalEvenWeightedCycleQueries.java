///  https://leetcode.com/problems/incremental-even-weighted-cycle-queries/description/


class Solution {
    public int numberOfEdgesAdded(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int ans = 0;

        for (int[] e : edges) {
            if (uf.union(e[0], e[1], e[2])) 
                ans++;
        }

        return ans;
    }

    static class UnionFind {
        int[] parent, parity;

        public UnionFind(int n) {
            parent = new int[n];
            parity = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                parity[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                int origParent = parent[x];
                parent[x] = find(parent[x]);
                parity[x] ^= parity[origParent];  
            }
            return parent[x];
        }

        public boolean union(int u, int v, int w) {
            int ru = find(u);
            int rv = find(v);

            if (ru == rv) {
                return (parity[u] ^ parity[v]) == w;
            }

            parent[ru] = rv;
            parity[ru] = parity[u] ^ parity[v] ^ w;

            return true;
        }
    }
}