///  https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/

/*
Recursive approach:
    cost(left,right)=0                                             if(left >= right)
                    min(i+max(cost(left,i−1),cost(i+1,right)))     otherwise 
*/

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
     
        for (int len = 2; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {

                int right = left + len - 1;
                dp[left][right] = Integer.MAX_VALUE;

                for (int i = left; i <= right; i++) {
                    int leftCost = (i > left) ? dp[left][i - 1] : 0;
                    int rightCost = (i < right) ? dp[i + 1][right] : 0;
                    
                    int worstCase = i + Math.max(leftCost, rightCost);

                    dp[left][right] = Math.min(dp[left][right], worstCase);
                }
            }
        }
        
        return dp[1][n];
    }
}