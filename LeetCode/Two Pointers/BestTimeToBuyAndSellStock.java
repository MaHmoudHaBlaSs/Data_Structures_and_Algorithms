// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    // Two Pointers Solution >> T: O(n)   S: O(1)
    public int maxProfit(int[] prices) {
        int best = 0, min = prices[0];
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min)
                min = prices[i];
            best = Math.max(best, prices[i]-min);
        }
        return best;
    }
    // Another Implementation
    public int maxProfit(int[] prices) {
         int minPrice = Integer.MAX_VALUE;
         int maxProfit = 0;
 
         for (int price : prices) {
             minPrice = Math.min(minPrice, price); 
             maxProfit = Math.max(maxProfit, price - minPrice); 
         }
 
         return maxProfit;
     }
}

