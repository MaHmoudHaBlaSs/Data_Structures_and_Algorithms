# https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/

class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        l, zeros, ans = 0, 0, 0

        for r in range(len(nums)):
            if nums[r] == 0: zeros += 1

            while l < r and zeros > 1:
                if nums[l] == 0: zeros -= 1
                l += 1

            ans = max(ans, r-l)
        
        return ans