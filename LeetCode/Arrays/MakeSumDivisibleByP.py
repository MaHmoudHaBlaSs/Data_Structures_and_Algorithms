# https://leetcode.com/problems/make-sum-divisible-by-p

# At first look to the problem you may say that it can be solved using Sliding Window
# but if you brainstorm the solution you will find out that it's pretty slow
# compared to the given solution and causes TLE.

# We already know it's a prefix problem right?
# the solution should find least subarray to remove to achieve sum % p = 0
# so, we are only interested in sum (in other words we are interested in remainings) of subarrays

# as we go with the prefix array we will have smth like this 
# [a b c d e] with remaining = 6 and suppose our k (sum % p) is 7 
# (we need to execlude a subarray with remaining k to have rest % p = 0) 
# so, for [a b c d e] we will need to exclude an array that makes remaining = 7
# it may be [a b], [a b c], [a] how can we know which previous prefix should be excluded?
# the solution is (curr_rem - target_rem) % p = k, but target is the varaible
# so target_rem = (curr_rem - k) % p is the solution (map remainings to indecies as you go)


class Solution:
    # Time: O(n)       Space: O(n)
    def minSubarray(self, nums: List[int], p: int) -> int: 

        k = sum(nums) % p
        if k ==  0:
            return 0

        dic = {0: -1}
        prefix_sum = 0
        res = len(nums)

        # For each position i with prefix sum has remainder rem
        # we want to find a previous position with remainder target 
        # such that the subarray between them has remainder k.
        # The math: (rem - prev) % p = k, so prev = (rem - k + p) % p.

        for i in range(len(nums)):
            prefix_sum = prefix_sum + nums[i]
            curr_rem = prefix_sum % p
            # we add + p to have proper math result for negative (curr_rem - k)
            target_rem = (curr_rem - k + p) % p

            if (dic.get(target_rem) is not None):
                res = min(res, i - dic[target_rem])
            dic[curr_rem] = i

        return -1 if res == len(nums) else res