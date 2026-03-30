#  https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/description/


class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        start, ans, ngtvCount, firstNgtv = 0,0,0,-1

        for i, num in enumerate(nums):
            if num == 0:
                start = i+1
                ngtvCount = 0
                firstNgtv = -1
            else:
                if num < 0:
                    ngtvCount += 1
                    if firstNgtv == -1:
                        firstNgtv = i 

                if (ngtvCount & 1) == 0:
                    ans = max(ans, i-start+1)
                else:
                    ans = max(ans, i-firstNgtv)

        return ans