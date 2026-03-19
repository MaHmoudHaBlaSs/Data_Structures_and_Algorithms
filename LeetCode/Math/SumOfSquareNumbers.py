# https://leetcode.com/problems/sum-of-square-numbers

class Solution:
    # Time: O(√n)          Space: O(1)
    def judgeSquareSum(self, c: int) -> bool:
        # For c = a^2 + b^2 , c = a^2 // Ex: [c = 4] -> [a = 2, b = 0]
        # a = √c (a,b are bounded to √c can't exceed it)
        a = int(sqrt(c))
        
        while (a >= 0) and (not sqrt(c - a*a).is_integer()):
            a = a - 1
        
        return False if a < 0 else True