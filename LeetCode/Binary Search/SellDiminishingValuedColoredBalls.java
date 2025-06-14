///  https://leetcode.com/problems/sell-diminishing-valued-colored-balls/description/

class Solution {
    private final int MOD = 1_000_000_007;

    public int maxProfit(int[] inventory, int orders) {
        int left = 1, right = 0;
        for (int ball : inventory) {
            right = Math.max(right, ball);
        }

        int k = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canFulfill(mid, orders, inventory)) {
                left = mid + 1;
                k = mid;
            } else {
                right = mid - 1;
            }
        }

        long profit = 0;
        for (int num : inventory) {
            if (num > k) {
                long n = num - k;
                orders -= n;
                long sum = ((n * (num + k + 1L)) / 2) % MOD;
                profit = (profit + sum) % MOD;
            }
        }

        profit = (profit + ((long) orders * k) % MOD) % MOD;
        return (int) profit;
    }

    private boolean canFulfill(int k, int orders, int[] inventory) {
        long count = 0;
        for (int ball : inventory) {
            if (ball >= k) {
                count += ball - k + 1;
                if (count >= orders) return true;
            }
        }
        return false;
    }
}
