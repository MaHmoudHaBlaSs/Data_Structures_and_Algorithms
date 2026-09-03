// https://leetcode.com/problems/path-existence-queries-in-a-graph-i/description/

class Solution {
    int parent[];
    int[] rank;
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n+1];
        rank = new int[n+1];
        boolean [] res = new boolean[queries.length];

        // Initialize each node to be its own parent
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                union(i, i + 1);
            }
        }

        for (int i = 0 ; i < queries.length ; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            if(find(x) == find(y)) {
                res[i] = true;
            }else {
                res[i] = false;
            }
        }
        return res;
    }
    public int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }
}