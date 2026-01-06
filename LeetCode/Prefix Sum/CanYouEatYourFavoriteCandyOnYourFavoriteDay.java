/// https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/description/

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        long[] prefix = new long[candiesCount.length+1];

        for(int i=0; i<candiesCount.length; ++i){
            prefix[i+1] = prefix[i] + candiesCount[i]; 
        }

        for(int i=0; i<queries.length; ++i){
            long days = queries[i][1] + 1; 
            int type = queries[i][0] + 1;

            ans[i] = days <= prefix[type] && prefix[type-1]+1 <= days * queries[i][2];  
        }

        return ans;
    }
}