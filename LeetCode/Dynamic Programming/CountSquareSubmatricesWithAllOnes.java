///  https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/

class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, ans = 0;
        int[][] dp = new int[n][m];

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(matrix[i][j] == 0) continue;

                int top = i>0 ? dp[i-1][j] : 0;
                int left = j>0 ? dp[i][j-1] : 0;
                int corner = i>0 && j>0 ? dp[i-1][j-1] : 0;

                dp[i][j] = 1 + Integer.min(top, Integer.min(left, corner));
                ans += dp[i][j];
            }
        }

        return ans;
    }
}