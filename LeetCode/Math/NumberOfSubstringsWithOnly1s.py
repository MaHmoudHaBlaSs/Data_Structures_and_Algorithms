# https://leetcode.com/problems/number-of-substrings-with-only-1s/description/

class Solution:
    def numSub(self, s: str) -> int:
        mod = 1_000_000_007
        n , ans, i = len(s), 0, 0

        while i < n:
            j = i
            while j < n and s[j] == '1':
                j += 1
            
            c = (j-i)
            i = j + 1
            ans = (ans + (c*(c+1) / 2) % mod) % mod 

        return int(ans)