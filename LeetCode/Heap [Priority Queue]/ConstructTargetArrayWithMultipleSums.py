# https://leetcode.com/problems/construct-target-array-with-multiple-sums/?envType=problem-list-v2&envId=dsa-sequence-valley-heap

import heapq as hq

class Solution:
    # Time: O(nlogn)         Space: O(1)
    def isPossible(self, target: List[int]) -> bool:
        hq.heapify_max(target)
        total = sum(target)

        while target[0] > 1:
            max_num = hq.heappop_max(target)
            remaining = total - max_num
                
            if remaining == 1: # [1 x] is valid for all cases (x >= 1) 
                return True 

            if remaining < 1:
                return False
            
            # for [9 5 3], sum = 17 assume next step is [17 5 3], sum = 25
            # remaining is 25 - 17 = 8 to know the element that was before max at same index
            # we use modulus to know what is the unkown number (complement for remaining) 
            # if the num before max was >= the max it's an invalid logic.
            before_max = max_num % remaining 
            if before_max == 0 or before_max >= max_num:
                return False

            hq.heappush_max(target, before_max)
            total = remaining + before_max


        return True