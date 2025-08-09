///  https://leetcode.com/problems/closest-dessert-cost/description/

class Solution {
    private int ans = 0x3f3f3f3f, minDiff = 0x3f3f3f3f;

    private void minCost(int[] toppingCosts,int i, int cost, int target){
        if(cost >= target || i == toppingCosts.length) return;

        //option 1
        minCost(toppingCosts, i+1, cost, target);
        
        //option 2
        cost += toppingCosts[i];
        int diff = Math.abs(cost - target);
        if(diff < minDiff || (diff == minDiff && cost <= ans)){
            minDiff = diff; 
            ans = cost;
        }
        minCost(toppingCosts, i+1, cost, target);

        //option 3
        cost += toppingCosts[i];
        diff = Math.abs(cost - target);
        if(diff < minDiff || (diff == minDiff && cost <= ans)){
            minDiff = diff; 
            ans = cost;
        }
        minCost(toppingCosts, i+1, cost, target);
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int base : baseCosts){
            int diff = Math.abs(base - target);
            if(diff < minDiff || (diff == minDiff && base <= ans)){
                minDiff = diff; 
                ans = base;
            }
            minCost(toppingCosts, 0, base, target);    
        }
        return ans; 
    }
}