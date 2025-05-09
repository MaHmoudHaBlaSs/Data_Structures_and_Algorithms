// https://leetcode.com/problems/min-cost-climbing-stairs/

// Top-down sol take O(N) Time & Space 

class Solution {
    int [] steps = new int [1004];
    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(steps , -1 );
        return Math.min(minCost(cost, 0), minCost(cost, 1));
    }
    public int minCost(int [] cost , int n) {
        if (n >= cost.length) return 0;
        if(steps[n] != -1) return steps[n];
        int op1 = minCost(cost, n+1) ;
        int op2 = minCost(cost, n+2) ;
        steps [n] = cost[n] + Math.min(op1, op2) ;
        return steps[n];
    }
}