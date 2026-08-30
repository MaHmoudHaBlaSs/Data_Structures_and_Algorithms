# https://leetcode.com/problems/max-chunks-to-make-sorted/

# The problem official solution uses a stack
# but this one is pretty clever solution and actually crystalizes the idea of always look for the real problem
# not what we should use to solve "Don't start by saying ahhh we need to use A or B " but start by asking yourself
# what is the real problem about and then you start wondering about what approach to use.

# The real problem is that we need to know where a chunk can be end starting from the current position.
# EX:
# Index : 0 1 2 3 4
# Value : 1 0 2 3 4
# starting by 1 we know that to close that chunk we must reach index 1, next when we reach 0 which close is 0 ( < 1)
# we know then that we can close and the chunk is [1 0], and so on

class Solution:
    def maxChunksToSorted(self, nums: list[int]) -> int:
        chunks = 0
        close = -1

        for i, num in enumerate(nums):
            close = max(close, num) # the num's right place is actually the index equals to it [3] = 3
            if close <= i:
                chunks += 1
                close = -1

        return chunks