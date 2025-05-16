/// https://leetcode.com/problems/minimum-cost-for-tickets/description/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366]; 
        int j = 0, n = days.length; 

        for(int i=1; i<366 && j<n; i++){
            dp[i] = dp[i-1];    
            if(i != days[j]) continue; //No travel today
             
            dp[i] = Math.min(dp[i-1] + costs[0], 
                Math.min( dp[i-7 >= 0? i-7 : 0] + costs[1] , 
                     dp[i-30 >=0? i-30 : 0]+costs[2]));

            j++; 
        }

        return dp[days[n-1]];
    }
}