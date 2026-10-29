///  https://leetcode.com/problems/maximum-points-tourist-can-earn/description/

class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[][] dp = new int[k+1][n];
        int ans = 0;

        for(int day=1; day<=k; ++day){
            for(int city=0; city<n; ++city){
                // option 1: stay
                dp[day][city] = dp[day-1][city] + stayScore[day-1][city]; 

                // option 2: travel 
                int maxScore = 0;
                for(int c = 0; c<n; ++c){
                    if(c != city) 
                        maxScore = Integer.max(maxScore, dp[day-1][c] + travelScore[c][city]);
                }

                dp[day][city] = Integer.max(dp[day][city], maxScore);
                ans = Integer.max(ans, dp[day][city]);
            }
        }

        return ans;      
    }
}