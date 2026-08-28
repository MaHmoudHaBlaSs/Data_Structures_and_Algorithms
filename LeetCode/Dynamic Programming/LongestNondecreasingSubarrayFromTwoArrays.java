///  https://leetcode.com/problems/longest-non-decreasing-subarray-from-two-arrays/description/


class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int ans = 1, n = nums1.length;
        int[][] dp = new int[2][n];
        Arrays.fill(dp[0],1);
        Arrays.fill(dp[1],1);

        for(int i=1; i<n; ++i){
            if(nums1[i] >= nums1[i-1]) dp[0][i] = dp[0][i-1] + 1;
            if(nums1[i] >= nums2[i-1]) dp[0][i] = Integer.max(dp[0][i], dp[1][i-1] + 1);

            if(nums2[i] >= nums1[i-1]) dp[1][i] = dp[0][i-1] + 1;
            if(nums2[i] >= nums2[i-1]) dp[1][i] = Integer.max(dp[1][i], dp[1][i-1] + 1);


            ans = Integer.max(ans, Integer.max(dp[0][i], dp[1][i]));
        }

        return ans;
    }
}