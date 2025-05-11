// https://leetcode.com/problems/coin-change-ii/


// T: O(amount*coins)                  S: O(amount*coins)
class Solution {
    int[][] memo = new int[5001][301];

    public int change(int amount, int[] coins) {
        for (int[] row: memo)
            Arrays.fill(row, -1);
        return getChange(amount, coins.length-1, coins);
    }

    public int getChange(int rem, int n, int[] coins){
        if (rem == 0) return 1;
        if (n == -1) return 0;
        if (memo[rem][n] != -1) return memo[rem][n];

        int opt1 = (rem >= coins[n])? getChange(rem-coins[n], n, coins):0;
        int opt2 = getChange(rem, n-1, coins);

        return memo[rem][n] = opt1 + opt2;
    }
}