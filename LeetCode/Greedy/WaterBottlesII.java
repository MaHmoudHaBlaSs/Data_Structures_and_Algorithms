// https://leetcode.com/problems/water-bottles-ii/

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles; 
        int empty = numBottles;

        while (empty >= numExchange) {
            empty -= numExchange;   
            numExchange++;          
            res++;                 
            empty++;                
        }

        return res;
    }
}