///  https://leetcode.com/problems/number-of-alternating-xor-partitions/description/

class Solution {
    private static final long MOD = 1_000_000_007L;
    
    public int alternatingXOR(int[] nums, int target1, int target2) {

        long[][] freq = new long[2][1 << 17];
        freq[1][0] = 1;

        int mask = 0;
        long last0 = 0, last1 = 0;

        for (int num : nums) {
            mask ^= num;

            last0 = freq[1][mask ^ target1];
            last1 = freq[0][mask ^ target2];

            freq[0][mask] = (freq[0][mask] + last0) % MOD;

            freq[1][mask] = (freq[1][mask] + last1) % MOD;
        }

        return (int)((last0 + last1) % MOD);
    }
}