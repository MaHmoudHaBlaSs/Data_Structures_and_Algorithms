#  https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        ans = 0
        maxMult = 0

        for num in nums:
            mults = 0

            while num > 0:
                if (num & 1) == 0: 
                    mults += 1
                    num >>= 1
                else:
                    ans += 1
                    num -= 1

            maxMult = max(maxMult, mults)

        ans += maxMult
        return ans 