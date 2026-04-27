/// https://leetcode.com/problems/minimum-removals-to-achieve-target-xor/description/


class Solution {
    private static final int oo = 0x3f3f3f3f;

    public int minRemovals(int[] nums, int target) {
        int totalXor = 0;
        for (int x : nums) totalXor ^= x;

        int need = totalXor ^ target;
        int MAX = 1 << 14; 

        int[] dp = new int[MAX];
        Arrays.fill(dp, oo);
        dp[0] = 0;

        for (int num : nums) {
            int[] next = dp.clone();

            for (int x = 0; x < MAX; x++) {
                if (dp[x] == oo) continue;
                int nx = x ^ num;
                next[nx] = Math.min(next[nx], dp[x] + 1);
            }
            dp = next;
        }

        return dp[need] == oo ? -1 : dp[need];
    }
}
