#  https://leetcode.com/problems/minimum-suffix-flips/description/

class Solution:
    def minFlips(self, target: str) -> int:
        flipped = False
        ans = 0

        for bit in target:
            if (bit == '1') ^ flipped:
                flipped = not flipped
                ans += 1

        return ans 