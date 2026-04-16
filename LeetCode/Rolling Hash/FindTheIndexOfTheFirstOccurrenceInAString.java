// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

// Tags: KMP algorithm - Rabin-Karp algorithm

// Robin-Karp
// The algorithm first computes a numeric hash for the pattern and for the initial substring of the text of equal length.
// It then slides a window through the text, updating the substring hash in constant time using a rolling hash formula.

// Rolling Hashing Formula: 
// H_new = (H_old - c_0 * b^(k-1)) * b + c_k
// H_old = abc -> (a * 31^2) + (b * 31^1) + (c * 31^0) = 100 (Ex)
// H_new = bcd ->  (100 - a * 31^2) * 31 + d == (b * 31^2) + (c * 31^1) + (d * 31^0)

class Solution {
    int base = 31;
    long MOD = 1_000_000_007;

    public int strStr(String haystack, String needle){
        int m = needle.length(), n = haystack.length();
        if (m > n) 
            return -1;

        // Math.pow(base, m-1) % MOD != iterative multiplying by base then % MOD.
        // In iterative multiplying, the result can overflow MOD more than 1 time, unlike pow() just oveflow 1 time. 
        long maxPower = 1;
        for (int i = 1; i <= m-1; i++)
            maxPower = (maxPower * base) % MOD;

        long patternHash = 0, hash = 0;

        // initial hashes
        for (int i = 0; i < m; i++){ 
            patternHash = (patternHash * base + needle.charAt(i)) % MOD; 
            hash = (hash * base + haystack.charAt(i)) % MOD; 
        }

        if (hash == patternHash) return 0;

        for (int i = m; i < n; i++){
            hash = ( hash - haystack.charAt(i - m) * maxPower % MOD + MOD ) % MOD; // remove first character
            hash = ( hash * base + haystack.charAt(i) ) % MOD; // append new character

            if (hash == patternHash)
                return i - m + 1;
        }
        
        return -1;
    }
}

// KMP
class Solution {
// Normal brute force solution gives O(n*m) time complexity
// with KMP we can enhance it to O(n) in cases that repeating the pattern
// We need to create LPS array

// pattern: ababcabab
// Index:  0123456789
// LPS:     001201234  -> represents the fallback index on miss match

    public int strStr(String haystack, String needle) {
        int[] lps = createLPS(needle); // Used only on missmatch
        for (int num: lps)
            System.out.print(num + " ");
        System.out.println();
        int j = 0;

        for (int i = 0; i < haystack.length(); i++){

            while ( j > 0 && haystack.charAt(i) != needle.charAt(j) ) // missmatch
                j = lps[j-1];
                
            if ( haystack.charAt(i) == needle.charAt(j) )
                j++;

            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    private int[] createLPS(String pattern){
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int prefix_len = 0;
        int i = 1;

        while (i < pattern.length()){
            if ( pattern.charAt(i) == pattern.charAt(prefix_len) ){
                prefix_len += 1;
                lps[i] = prefix_len;
                i += 1;
            }
            else{
                if (prefix_len != 0)
                    prefix_len = lps[prefix_len - 1];
                
                else{
                    lps[i] = 0;
                    i += 1;
                }
            }
        }
        return lps;
    }
}