/// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

/*
-Can you solve it if it's alllowed to do only one transaction?
-For 2 transactions: 
    partition the array into two parts, solve it for each part
    the answer is the best partition bewteen any valid partitions  
*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, ans = 0;
        int[] left = new int[n], right = new int[n];

        int minLeft = prices[0], maxRight = prices[n-1];

        for(int i=0; i<n; i++){
            left[i] = Math.max(i > 0 ? left[i-1] : 0, prices[i] - minLeft);
            minLeft=  Math.min(minLeft, prices[i]);
            
            int j = n - i - 1;
            right[j] = Math.max(j+1 < n? right[j+1] : 0, maxRight - prices[j]);
            maxRight = Math.max(maxRight, prices[j]);
        }
        
        for(int i=0; i<n; i++)
            ans = Math.max(ans, left[i] + right[i]);
        
        return ans;
    }
}