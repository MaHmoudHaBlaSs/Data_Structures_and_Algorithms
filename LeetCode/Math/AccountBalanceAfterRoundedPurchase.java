// https://leetcode.com/problems/account-balance-after-rounded-purchase/description/


class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return (int) (100 - ( Math.round(purchaseAmount / 10.0) * 10));
    }
}