///  https://leetcode.com/problems/count-sorted-vowel-strings/description/

/*
Mathematical analysi:
    n=0  1, 1, 1, 1, 1
    n=1  1, 2, 3, 4, 5
    n=2  1, 3, 6, 10, 15

dp[i][j] = sum of dp[i-1][k] where k from 0 to j 
*/

class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];
        
        Arrays.fill(dp[0], 1);

        for(int i=1; i<=n; i++){
            int sum = 0;

            for(int j=0; j<5; j++){
                sum += dp[i-1][j];
                dp[i][j] = sum;
            }
        }

        return dp[n][4];
    }
}