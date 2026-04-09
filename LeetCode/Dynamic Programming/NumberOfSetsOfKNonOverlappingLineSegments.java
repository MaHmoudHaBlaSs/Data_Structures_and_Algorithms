///  https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/description/

class Solution {
    private final int mod = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        long[][] dp = new long[n][k + 1];
        long[][] prefix = new long[n][k + 1];

        
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            prefix[i][0] = i + 1; 
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < n; i++) {
                dp[i][j] = (dp[i - 1][j] + prefix[i - 1][j - 1]) % mod;
                
                prefix[i][j] = (prefix[i - 1][j] + dp[i][j]) % mod;
            }
        }

        return (int) dp[n - 1][k];
    }
}
