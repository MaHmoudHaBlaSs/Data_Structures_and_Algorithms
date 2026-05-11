///  https://leetcode.com/problems/maximum-score-using-exactly-k-pairs/description/


class Solution {
    private static final long neg = Long.MIN_VALUE;

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        long[][][] dp = new long[n][m][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], neg);
            }
        }

        for (int l = 0; l < k; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i > 0) {
                        dp[i][j][l] = Long.max(dp[i][j][l], dp[i - 1][j][l]);
                    }

                    if (j > 0) {
                        dp[i][j][l] = Long.max(dp[i][j][l], dp[i][j - 1][l]);
                    }

                    long val = (long) nums1[i] * nums2[j];

                    if (l == 0) {
                        dp[i][j][l] = Math.max(dp[i][j][l], val);
                    }
                    else if (i > 0 && j > 0 && dp[i - 1][j - 1][l - 1] != neg) {
                        dp[i][j][l] = Math.max(dp[i][j][l], val + dp[i - 1][j - 1][l - 1]);
                    }                    
                }
            }
        }
    
        
        return dp[n-1][m-1][k-1]; 
    }

}