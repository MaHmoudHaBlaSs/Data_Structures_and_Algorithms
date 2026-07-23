///  https://leetcode.com/problems/maximum-xor-of-subsequences/description/

class Solution {
    public int maxXorSubsequences(int[] nums) {
        int[] basis = new int[31];

        for (int x : nums) {
            int cur = x;

            for (int b = 30; b >= 0; b--) {
                if (((cur >> b) & 1) == 0) continue;

                if (basis[b] == 0) {
                    basis[b] = cur;
                    break;
                }

                cur ^= basis[b];
            }
        }

        int ans = 0;

        for (int b = 30; b >= 0; b--) {
            if ((ans ^ basis[b]) > ans)
                ans ^= basis[b];
        }

        return ans;
    }
}