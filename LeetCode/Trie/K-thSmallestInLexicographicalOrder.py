# https://leetcode.com/problems/k-th-smallest-in-lexicographical-order

# It's hard to come up with the solution lonely.
# Time: O(Log_10(n)^2)
class Solution:
    def findKthNumber(self, n: int, k: int) -> int:

        def howManyNumbers(low_bound: int):
            high_bound = low_bound + 1
            nums = 0

            while low_bound <= n:
                nums += min(high_bound, n+1) - low_bound
                low_bound *= 10
                high_bound *= 10

            return nums


        num = 1
        accumulated_nums = 0

        while True:
            branch_nums = howManyNumbers(num) # Log_10 (n)

            if (accumulated_nums + branch_nums) >= k: # kth num is inside that branch
                accumulated_nums += 1
                if accumulated_nums == k:
                    return num
                num *= 10

            else: # kth num is not inside that branch
                num += 1
                accumulated_nums += branch_nums