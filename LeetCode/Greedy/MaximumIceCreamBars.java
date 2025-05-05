// https://leetcode.com/problems/maximum-ice-cream-bars/description/


// T: O(n)             S: O(Max(cost))
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = Arrays.stream(costs).max().getAsInt();
        int[] freq = new int[n+1];
        int max = 0;

        for (int cost: costs)
            freq[cost]++;

        for (int i = 1; i < freq.length ; i++){
            int canBuy = coins/i;
            if (canBuy >= 1){
                int bought = Math.min(freq[i], canBuy);
                max += bought;
                coins -= bought * i;
            }
            else break;
        }
        return max;
    }
}