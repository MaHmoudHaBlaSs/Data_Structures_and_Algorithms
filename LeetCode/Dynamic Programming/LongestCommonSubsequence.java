////  https://leetcode.com/problems/longest-common-subsequence/description/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m]; 

        for(int i=0; i<n; i++){
            char c1 = text1.charAt(i);
            for(int j=0; j <m; j++){
                if(c1 == text2.charAt(j)) 
                    dp[i][j] = (i-1 >= 0 && j-1 >= 0 ? dp[i-1][j-1] : 0) + 1;
                else
                    dp[i][j] = Math.max((i-1>=0 ? dp[i-1][j] : 0), (j-1>=0 ? dp[i][j-1] : 0) );
            }
        }

        return dp[n-1][m-1]; 
    }
}