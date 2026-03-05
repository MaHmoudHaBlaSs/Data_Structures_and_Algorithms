#  https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/

class Solution:
    def numSplits(self, s: str) -> int:
        left , right = [0] * 26, [0] * 26
        
        for c in s: right[ord(c) - ord('a')] += 1

        ans = 0

        for c in s: 
            idx = ord(c) - ord('a')
            right[idx] -= 1
            left[idx] += 1

            d1, d2 = 0, 0
            for i in range(26):
                if left[i] > 0: d1 += 1
                if right[i] > 0: d2 += 1

            ans += (d1 == d2)

        return ans
        