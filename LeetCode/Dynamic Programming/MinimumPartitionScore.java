///  https://leetcode.com/problems/minimum-partition-score/description/

class Solution {
    public long minPartitionScore(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[][] dp = new long[k + 1][n + 1];

        //base case: one partition
        for (int i = 1; i <= n; i++) {
            dp[1][i] = cost(1, i, prefix);
        }

        //build remaining layers
        for (int part = 2; part <= k; part++) {
            compute(part, part, n, part - 1, n - 1, dp, prefix);
        }

        return dp[k][n];
    }

    private void compute(int part, int left, int right, int optL, int optR, long[][] dp, int[] prefix) {
        if (left > right) return;

        int mid = (left + right) >> 1;
        long best = Long.MAX_VALUE;
        int bestSplit = -1;

        for (int p = optL; p <= Math.min(mid - 1, optR); p++) {
            long candidate = dp[part - 1][p] + cost(p + 1, mid, prefix);

            if (candidate < best) {
                best = candidate;
                bestSplit = p;
            }
        }

        dp[part][mid] = best;

        compute(part,left,mid - 1,optL,bestSplit,dp,prefix);
        compute(part, mid + 1, right, bestSplit, optR, dp, prefix);
    }

    private long cost(int l, int r, int[] prefix) {
        long sum = prefix[r] - prefix[l - 1];
        return (sum * (sum + 1)) >> 1;
    }
}