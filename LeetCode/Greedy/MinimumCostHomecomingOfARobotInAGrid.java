///  https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/description/


class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans = 0;

        if(homePos[0] > startPos[0]){
            while(startPos[0] != homePos[0]) ans += rowCosts[++startPos[0]];
        }else{
            while(startPos[0] != homePos[0]) ans += rowCosts[--startPos[0]];
        }
        
        if(homePos[1] > startPos[1]){
            while(startPos[1] != homePos[1]) ans += colCosts[++startPos[1]];
        }else{
            while(startPos[1] != homePos[1]) ans += colCosts[--startPos[1]];
        }

        return ans;    
    }
}
