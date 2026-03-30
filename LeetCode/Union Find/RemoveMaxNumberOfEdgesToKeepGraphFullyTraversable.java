///  https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n + 1);
        UnionFind bob = new UnionFind(n + 1);

        int usedEdges = 0;

        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean a = alice.union(e[1], e[2]);
                boolean b = bob.union(e[1], e[2]);

                if (a | b) usedEdges++;
            }
        }

        for (int[] e : edges) {
            if (e[0] == 1) {
                if (alice.union(e[1], e[2])) {
                    usedEdges++;
                }
            }
        }

        for (int[] e : edges) {
            if (e[0] == 2) {
                if (bob.union(e[1], e[2])) {
                    usedEdges++;
                }
            }
        }

        if (alice.getComponents() != 1 || bob.getComponents() != 1) {
            return -1;
        }

        return edges.length - usedEdges;
    }

    static class UnionFind {
        private int[] parent;
        private int components;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            components = n - 1; 
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;

            parent[pa] = pb;
            components--;
            return true;
        }

        public int getComponents(){
            return components;
        }
    }
}