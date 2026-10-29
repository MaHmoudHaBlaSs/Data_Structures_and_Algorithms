///  https://leetcode.com/problems/find-the-maximum-factor-score-of-array/description/

class Solution {
    public long maxScore(int[] nums) {
        int n = nums.length;

        if (n == 1) return (long) nums[0] * nums[0];

        long[] preGcd = new long[n], preLcm = new long[n];
        long[] sufGcd = new long[n], sufLcm = new long[n];

        preGcd[0] = preLcm[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preGcd[i] = gcd(preGcd[i - 1], nums[i]);
            preLcm[i] = lcm(preLcm[i - 1], nums[i]);
        }

        sufGcd[n - 1] = sufLcm[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sufGcd[i] = gcd(sufGcd[i + 1], nums[i]);
            sufLcm[i] = lcm(sufLcm[i + 1], nums[i]);
        }

        long ans = preGcd[n - 1] * preLcm[n - 1]; 
        ans = Math.max(ans, sufGcd[1] * sufLcm[1]);        
        ans = Math.max(ans, preGcd[n-2] * preLcm[n-2]);

        for (int i = 1; i < n-1; i++) {
            long g = gcd(preGcd[i - 1], sufGcd[i + 1]);
            long l = lcm(preLcm[i - 1], sufLcm[i + 1]);

            ans = Math.max(ans, g * l);
        }

        return ans;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}