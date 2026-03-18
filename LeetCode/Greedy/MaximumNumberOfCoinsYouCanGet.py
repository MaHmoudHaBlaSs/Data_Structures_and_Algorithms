#  https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/

class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        piles.sort()
        n = (len(piles) // 3) * 2

        ans, i = 0, 1
        while i < n:
            ans += piles[-(i+1)]
            i += 2

        return ans