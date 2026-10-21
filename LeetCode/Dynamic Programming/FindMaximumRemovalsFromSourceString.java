///  https://leetcode.com/problems/find-maximum-removals-from-source-string/description/

class Solution {
    private Integer[][] dp;
    private boolean[] removable;

    public int maxRemovals(String source, String pattern, int[] targetIndices) {

        removable = new boolean[source.length()];

        for (int idx : targetIndices) {
            removable[idx] = true;
        }

        dp = new Integer[source.length() + 1][pattern.length() + 1];

        return solve(0, 0, source, pattern);
    }

    private int solve(int k, int j, String source, String pattern) {
        if (j == pattern.length()) {
            int cnt = 0;

            for (int i = k; i < source.length(); i++) {
                if (removable[i]) cnt++;
            }

            return cnt;
        }

        if (k == source.length()) {
            return -1000000;
        }

        if (dp[k][j] != null) {
            return dp[k][j];
        }

        // ignore current character
        int ans = solve(k + 1, j, source, pattern);

        // use current character
        if (source.charAt(k) == pattern.charAt(j)) {
            ans = Integer.max(ans, solve(k + 1, j + 1, source, pattern));
        }

        // remove current character
        if (removable[k]) {
            ans = Integer.max(ans, 1 + solve(k + 1, j, source, pattern));
        }

        return dp[k][j] = ans;
    }
}
