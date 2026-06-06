///   https://leetcode.com/problems/minimum-cost-to-acquire-required-items/description/

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0; 

        if(costBoth <= cost1+cost2){
            int min = Integer.min(need1, need2);
            ans += (long)costBoth * min;
            need1 -= min; 
            need2 -= min; 

            ans += (long)Integer.min(cost1, costBoth) * need1;
            ans += (long)Integer.min(cost2, costBoth) * need2;
        }else{
            ans += (long)cost1*need1;
            ans += (long)cost2*need2;
        }


        return ans;
    }
}