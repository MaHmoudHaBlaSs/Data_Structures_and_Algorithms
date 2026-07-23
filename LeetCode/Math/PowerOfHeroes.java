///   https://leetcode.com/problems/power-of-heroes/description/
/*
 * Idea: Sort the array so each element can be treated as the maximum of every subset
 * where it appears.
 *
 * The total answer consists of two parts:
 *
 * 1. Single-element subsets:
 *      contribution = nums[i]^3
 *
 * 2. Multi-element subsets:
 *      For every index j (acting as the maximum),
 *      every previous element can be the minimum.
 *
 *      A fixed pair (i, j) appears together in exactly 2^(j-i-1) subsets,
 *      since every element between them may be either chosen or skipped.
 *
 *      Therefore:
 *          contribution(j) = nums[j]^2 *
 *              sum(nums[i] * 2^(j-i-1)), where i < j
 *
 * Instead of recomputing this weighted sum for every j, maintain it
 * in `sum`, allowing each iteration to run in O(1).
 *
 * Time Complexity:  O(n log n) 
 * Space Complexity: O(1)
 */

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);

        long ans = 0;

        for (int num : nums) {
            long cube = (long) num * num % MOD;
            cube = cube * num % MOD;
            ans = (ans + cube) % MOD;
        }

        long sum = 0;
        long powerOfTwo = 1; // 2^(j-1)

        for (int j = 1; j < nums.length; j++) {
            sum = (sum + nums[j - 1] * modInverse(powerOfTwo)) % MOD;

            long contribution = (long) nums[j] * nums[j] % MOD;
            contribution = contribution * powerOfTwo % MOD;
            contribution = contribution * sum % MOD;

            ans = (ans + contribution) % MOD;
            powerOfTwo = powerOfTwo * 2 % MOD;
        }

        return (int) ans;
    }

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
}