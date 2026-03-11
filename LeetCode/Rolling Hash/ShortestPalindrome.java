// https://leetcode.com/problems/shortest-palindrome/description/

    /**
     * Finds the longest palindromic prefix by comparing forward and reverse rolling hashes.
     * The remaining suffix is then reversed and prepended to the original string.
     */

class Solution {
    static long base = 31;
    static long mod = 1000000007;

    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        long[] hash = new long[n + 1];
        long[] revHash = new long[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * base) % mod;

            // Forward hash: prefix hash of s
            int valFwd = s.charAt(i - 1) - 'a' + 1;
            hash[i] = (hash[i - 1] * base + valFwd) % mod;

            // Reverse hash: prefix hash of reversed s
            int valBwd = s.charAt(n - i) - 'a' + 1;
            revHash[i] = (revHash[i - 1] * base + valBwd) % mod;
        }

        // Check prefixes from longest to shortest
        int longestPalindromePrefixLen = 0;
        for (int len = n; len >= 1; len--) {
            long fwd = getHash(hash, power, 1, len);
            long bwd = getHash(revHash, power, n - len + 1, n);

            if (fwd == bwd) {
                longestPalindromePrefixLen = len;
                break;
            }
        }

    
        String suffix = s.substring(longestPalindromePrefixLen);
        return new StringBuilder(suffix).reverse().toString() + s;
    }

    public long getHash(long[] h, long[] p, int l, int r) {
        long result = h[r] - (h[l - 1] * p[r - l + 1]) % mod;
        
        if (result < 0) {
            result += mod;
        }
        return result;
    }
}