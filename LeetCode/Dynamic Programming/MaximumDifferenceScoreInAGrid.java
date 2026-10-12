///  https://leetcode.com/problems/maximum-difference-score-in-a-grid/description/

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size(), m = grid.get(0).size(); 
        
        int[][] dp = new int[n][m]; // dp[i][j] = min num sarting for (0,0) to (i,j)
        
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                int curr = grid.get(i).get(j);

                dp[i][j] = curr;

                if(i > 0) {
                    dp[i][j] = Integer.min(curr, dp[i-1][j]);
                    ans = Integer.max(ans, curr - dp[i-1][j]);    
                }

                if(j > 0) {
                    dp[i][j] = Integer.min(dp[i][j], dp[i][j-1]);
                    ans = Integer.max(ans, curr - dp[i][j-1]);    
                }                
            }
        }

        return ans;
    }
}