///  https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long mod = 1_000_000_007;

        int[][] dp = new int[t+1][26];
        for(int i=0; i<s.length(); ++i){
            dp[0][s.charAt(i)-'a']++;
        }

        for(int i=1; i<=t; ++i){
            for(int j=1; j<26; ++j){
                dp[i][j] = dp[i-1][j-1];
            }

            dp[i][0] = dp[i-1][25];
            dp[i][1] = (int)(((long)dp[i][1] + dp[i-1][25]) % mod);
        }

        long ans = 0;
        for(int num : dp[t]){
            ans = (ans + num) % mod;
        }

        return (int)ans;
    }
}