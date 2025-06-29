///   https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

public class Solution {
    private const int MOD = 1_000_000_007;

    public int NumSubseq(int[] nums, int target) {
        Array.Sort(nums);
        int n = nums.Length;
        int[] pow2 = new int[n];
        pow2[0] = 1;

        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int res = 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (res + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
