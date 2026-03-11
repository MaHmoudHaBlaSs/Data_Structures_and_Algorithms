#  https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/description/


class Solution:
    def maxNonOverlapping(self, nums: List[int], target: int) -> int:
        mp = {0: 0}
        ans, sum = 0, 0

        for num in nums:
            sum += num

            needed = sum - target
            numberOfSubarrays = 0

            if needed in mp:
                numberOfSubarrays = mp.get(needed) + 1

            ans = max(ans, numberOfSubarrays)
            mp[sum] = ans

        return ans 