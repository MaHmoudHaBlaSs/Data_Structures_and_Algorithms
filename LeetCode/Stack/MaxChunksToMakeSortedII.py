# https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

# Time: O(n)       Space: O(n)
class Solution:
    def maxChunksToSorted(self, nums: list[int]) -> int:
        stack = []

        def merge():
            if len(stack) > 1:
                a_min, a_max = stack.pop()

                if a_min < stack[-1][1]: # if merge
                    b_min, b_max = stack.pop()
                    stack.append((min(a_min, b_min), max(a_max, b_max)))
                    merge()

                else: # if no merge
                    stack.append((a_min, a_max))


        for num in nums:
            stack.append((num, num))
            merge()

        return len(stack)