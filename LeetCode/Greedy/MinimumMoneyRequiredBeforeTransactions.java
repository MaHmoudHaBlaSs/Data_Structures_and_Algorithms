// https://leetcode.com/problems/minimum-money-required-before-transactions/description/


class Solution {
    public long minimumMoney(int[][] transactions) {
        long totalLoss = 0;
        long maxRefund = 0;

        for (int[] transaction : transactions) {
            int cost = transaction[0];
            int cashback = transaction[1];

            if (cost > cashback) {
                totalLoss += (cost - cashback);
                // Handle if is the last transaction (loss = cost - cashback) -> (cost = loss + cashback)
                maxRefund = Math.max(maxRefund, cashback);
            }else{
                // Handle if is the last transaction we just need to have cost of the transaction to make it 
                maxRefund = Math.max(maxRefund, cost);
            }
        }

        return totalLoss + maxRefund;
    }
}