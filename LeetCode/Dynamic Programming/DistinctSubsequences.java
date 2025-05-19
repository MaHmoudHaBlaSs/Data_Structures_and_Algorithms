///    https://leetcode.com/problems/distinct-subsequences/description/

/*
Consider using top-down recurssive:
ways(i,j) is the solution of the problem with frist i characters form t ans first j chars from s.

            1                               if(i == 0)
ways(i,j) = 0                               if(i > j || j == 0) 
            ways(i,j-1)                     if(t[i] != s[j])
            ways(i,j-1) + ways(i-1,j-1)     if(t[i] == s[j])

Final answer is ways(t.length(), s.length())
*/

class Solution { 
    public int numDistinct(String s, String t) {
        int n = t.length(), m = s.length();
        int[][] dp = new int[n][m]; 
        
        for(int i=0; i<n; i++){
            for(int j=i; j<m; j++){
                
                if(t.charAt(i) != s.charAt(j)) dp[i][j] = (j > 0 ? dp[i][j-1] : 0);
                else {
                    int op1 = j > 0 ? dp[i][j-1] : 0;
                    int op2 = i > 0 ? (j > 0 ? dp[i-1][j-1] : 0) : 1;
                    
                    dp[i][j] = op1 + op2;
                }
            }
        }

        return dp[n-1][m-1];
    }
}