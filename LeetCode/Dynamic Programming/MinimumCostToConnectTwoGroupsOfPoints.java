/// https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/description/


class Solution {
    private static final int oo = 0x3f3f3f3f;

    public int connectTwoGroups(List<List<Integer>> cost) {
        int n = cost.size();
        int m = cost.get(0).size();

        int[] minCost = new int[m];
        Arrays.fill(minCost, oo);

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                minCost[j] = Math.min(minCost[j], cost.get(i).get(j));
            }
        }

        // memo[i][mask]
        int[][] memo = new int[n][1 << m];
        for (int[] row : memo) Arrays.fill(row, -1);

        return minCost(0, 0, memo, cost, minCost);
    }

    private int minCost(int i, int mask, int[][] memo, List<List<Integer>> cost, int[] minCostArr) {
        int n = cost.size();
        int m = cost.get(0).size();

        if (i == n) {
            int extra = 0;

            // connect remaining group2 nodes
            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) == 0) {
                    extra += minCostArr[j];
                }
            }

            return extra;
        }

        if (memo[i][mask] != -1) return memo[i][mask];

        int ans = oo;
        for (int j = 0; j < m; j++) {
            int newMask = mask | (1 << j);

            int cur = cost.get(i).get(j) + minCost(i + 1, newMask, memo, cost, minCostArr);

            ans = Math.min(ans, cur);
        }

        return memo[i][mask] = ans;
    }
}