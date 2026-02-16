# https://leetcode.com/problems/first-missing-positive

class Solution:
    # Time: O(n)      Space: O(1)
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)

        for i in range(len(nums)):
            if nums[i] <= 0 or nums[i] > n:
                nums[i] = n+1 # Indication for invalid values

        for i in range(len(nums)):
            num = abs(nums[i])
            
            if num > n: # make sure it's valid
                continue

            num = num - 1 # convert to 0-indexed
            if (nums[num] > 0): # to prevent duplicates
                nums[num] = nums[num] * -1

        for i in range(len(nums)):
            if nums[i] > 0:
                return i+1

        return n+1