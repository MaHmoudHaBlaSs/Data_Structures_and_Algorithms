# https://leetcode.com/problems/binary-subarrays-with-sum

# Very Clever Solution
# T: O(n)       S: O(1)
class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        # This helper function to Count all sub arrays which sum is <= target 
        def countSubArrays(nums, target):
            res = 0
            sum = 0
            tail = 0
            
            for head in range(len(nums)):
                sum += nums[head]

                while sum > target and tail <= head:
                    sum -= nums[tail]
                    tail += 1

                # increment res by all sub arrays bounded between tail and head
                # it actually counts indexes  
                res += head - tail + 1
            
            return res
    
     # Sub Arrays with sum equal to goal is actually:
     # (Sub Arrays with sum <= goal) - (Sub Arrays with sum <= goal-1)
    return countSubArrays(nums, goal) - countSubArrays(nums, goal-1) 
