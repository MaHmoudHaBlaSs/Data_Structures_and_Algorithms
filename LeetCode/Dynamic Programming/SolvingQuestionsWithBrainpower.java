///  https://leetcode.com/problems/solving-questions-with-brainpower/description/


class Solution {
    public long mostPoints(int[][] questions) {
        int n =  questions.length;
        long[] dp = new long[n]; 
        long ans = 0;
        
        for(int i=0; i<n; i++){
            int points =  questions[i][0], next = i + questions[i][1] + 1; 
            
            if(i+1 < n)
                dp[i+1] = Math.max(dp[i+1], dp[i]);

            dp[i] += points;
            
            if(next < n)
                dp[next] =  Math.max(dp[next] , dp[i]);

            if(dp[i] > ans) ans = dp[i]; 
        }

        return ans;
    }
}