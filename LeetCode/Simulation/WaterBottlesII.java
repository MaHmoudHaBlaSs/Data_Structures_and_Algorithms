///  https://leetcode.com/problems/water-bottles-ii/description/

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0, empty = 0;

        while(numBottles > 0){
            ans += numBottles;
            empty += numBottles;

            numBottles = 0;

            if(empty >= numExchange){
                empty -= numExchange;
                numBottles++;
                numExchange++;
            }
        }

        return ans;
    }
}