# https://leetcode.com/problems/largest-rectangle-in-histogram/?envType=problem-list-v2&envId=dsa-linear-shoal-monotonic-stack

class Solution:
    #  T: O(n)      S: O(n)
    def largestRectangleArea(self, heights: List[int]) -> int:
        # Stack entry is [height, start_index]
        # start_index is the first valid index that makes contiguous rectangle
        stack = [] 
        max_area = 0

        # The area is calculated and compared on pops... 
        # storing it(area) in the stack will lead to wrong or more complex sol.
        for i, height in enumerate(heights):
            start = i

            while (len(stack) is not 0) and (stack[-1][0] > height):
                popped = stack.pop()

                max_area = max(max_area, popped[0] * (i - popped[1]))
                start = popped[1]
            
            stack.append((height, start))

        while len(stack) is not 0:
            popped = stack.pop()
            max_area = max(max_area, popped[0] * (len(heights) - popped[1]))

        return max_area     