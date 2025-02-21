// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    //Two Pointers Solution >> T: O(n)   S: O(1)
    public int maxProfit(int[] prices) {
        int best = 0, min = prices[0];
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min)
                min = prices[i];
            best = Math.max(best, prices[i]-min);
        }
        return best;
    }
}
