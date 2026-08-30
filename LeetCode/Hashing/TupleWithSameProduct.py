# https://leetcode.com/problems/tuple-with-same-product/

import math

class Solution:
    def tupleSameProduct(self, nums: list[int]) -> int:
        freq = {}
        for i in range(0, len(nums)):
            for j in range(i+1, len(nums)):
                product = nums[i] * nums[j]
                freq[product] = freq.get(product, 0) + 1

        res = 0
        # Ex: for a product value of 12 you have 3 pairs A:(2, 6) B:(3, 4) C:(12, 1)
        # how to calculate all possible combinations of pairs ?
        # ABC => AB, AC, BC >> these are distinct combinations we can get, but we care about order
        # suppose taking AB >> (2, 6, 3, 4) (2, 6, 4, 3) (6, 2, 3, 4) (6, 2, 4, 3) and another 4
        # groups if we swapped (2,6) with (3,4) >> (3, 4, 2, 6)
        # so we end up with 8 groups for each distinct combination, 
        # now the problem simplifies to distinctComb(n) * 8 , how to get this function?
        # for ABCD >> AB, AC, AD, BC, BD, CD >> (3 + 2 + 1) it's a summation formula
        # which can be formally stated as: n(n-1) / 2
        for val in freq.values():
            if val > 1:
                res += (val * (val-1)// 2) * 8
        return res
            