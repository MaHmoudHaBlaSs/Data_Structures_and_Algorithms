#  https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/description/


class Solution:
    def minDays(self, n: int) -> int:
        memo = {}

        def minDaysToEat(oranges: int) -> int:
            if oranges <= 1:
                return oranges

            if oranges in memo:
                return memo[oranges]

            by2 = (oranges % 2) + 1 + minDaysToEat(oranges // 2)
            by3 = (oranges % 3) + 1 + minDaysToEat(oranges // 3)

            memo[oranges] = min(by2, by3)
            return memo[oranges]

        return minDaysToEat(n)