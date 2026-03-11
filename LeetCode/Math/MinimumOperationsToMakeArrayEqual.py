#  https://leetcode.com/problems/minimum-operations-to-make-array-equal/description/


class Solution:
    def minOperations(self, n: int) -> int:
        n -= 1

        if n%2 == 0:
            n //= 2
            return n * (n+1)
        else:
            n = n//2 + 1
            return n * n 