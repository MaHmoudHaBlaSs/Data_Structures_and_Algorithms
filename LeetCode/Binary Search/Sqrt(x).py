## https://leetcode.com/problems/sqrtx/description

# Time: O(log(n))
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0: return 0
        elif x == 1: return 1

        l, r = 1, (x//2)+1

        while l <= r:
            m = (l + r)//2

            if m ** 2 == x:
                return m
            elif m ** 2 > x:
                r = m - 1
            else:
                l = m + 1
        return r