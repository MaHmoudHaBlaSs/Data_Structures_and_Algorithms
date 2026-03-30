# https://leetcode.com/problems/number-of-ways-to-split-a-string/description/


class Solution:
    def numWays(self, s: str) -> int:
        MOD = 1_000_000_007

        ones = 0
        for ch in s:
            if ch == '1': 
                ones += 1

        if ones % 3 != 0: 
            return 0

        if ones == 0: 
            if len(s) < 3: return 0
            else:
                n = len(s) - 2
                return (n*(n+1) // 2) % MOD
            
        ones = ones//3
        l, r= 0, len(s)-1
        l_count, r_count = 0, 0
        c1,c2=0,0
        while l_count <= ones:
            if l_count == ones: c1 += 1

            if s[l] == '1': l_count += 1

            l += 1

        while r_count <= ones:
            if r_count == ones: c2 += 1
            
            if s[r] == '1': r_count += 1

            r -= 1


        return (c1 * c2) % MOD