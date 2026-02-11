///  https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/

class Solution {
    private static final int oo = 0x3f3f3f3f;
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        for (int i = 0; i <= n1; i++) Arrays.fill(dp[i], -oo);
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int prod = nums1[i - 1] * nums2[j - 1];

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i][j], prod);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prod);
            }
        }
        
        return dp[n1][n2];
    }
}