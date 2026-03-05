# https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/


# notice the dp (solution) array for this example:
# target = [3,2,6,5,2,3]
# dp     = [3,3,7,7,7,8]  
# diff = target[i] - targest[i-1]
# dp[i] = (diff > 0 ? dp[i-1] + diff : dp[i-1])

class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        ans = 0
        prev = 0

        for num in target:
            if num > prev:
                ans += num - prev
            prev = num

        return ans