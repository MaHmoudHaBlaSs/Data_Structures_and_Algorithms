// https://leetcode.com/problems/find-if-path-exists-in-graph/description/


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu = new DSU(n);
        for(int[] edge : edges){
            dsu.union(edge[0],edge[1]);
        }
        return dsu.find(source) == dsu.find(destination);
    }
    class DSU {
        private int[] parent;
        private int[] size;
        private int count; // Number of disjoint sets

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Each element is its own representative
                size[i] = 1;   // Initial height/rank is 1
            }
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            // Path Compression
            return parent[i] = find(parent[i]);
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                // Union by Rank: Attach smaller tree under larger tree
                if (size[rootI] > size[rootJ]) {
                    parent[rootJ] = rootI;
                } else if (size[rootI] < size[rootJ]) {
                    parent[rootI] = rootJ;
                } else {
                    parent[rootI] = rootJ;
                    size[rootJ]++;
                }
                count--; // One merge happened, so one less set
                return true; // Union successful
            }
            return false; // Already in the same set (Cycle detected!)
        }

        public int getCount() {
            return count;
        }
    }
}