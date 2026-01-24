# https://leetcode.com/problems/find-k-pairs-with-smallest-sums/?envType=problem-list-v2&envId=dsa-sequence-valley-heap

import heapq as hq

class Solution:
    # Time: O(nlogn)      Space: O(n)
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        res = []
        heap = [] # heap node is (sum, i, j)
        
        # Imagine nums1 and nums2 as 2D matrix
        #      2 _ 4 _ 6  -> j
        #  i |__ |__ | __ |
        #  1 | 3 | 5 | 7  |
        #  5 | 7 | 9 | 11 |
        # 11 | 13| 15| 17 |
        # Assume long k, you will start with column_0 (j = 0) added to the heap
        # and once we pop from that heap, we get the least sum pair, then you can move left (j+1)
        # to get the next greater pair after the least one we popped.
        # and the algorithm continues. (pop from heap -> add next pair (if valid))

        for i in range(min(len(nums1), k)):
            hq.heappush(heap, (nums1[i]+nums2[0], i, 0))

        while heap and k > 0:
            pair_sum, i, j = hq.heappop(heap)
            res.append([nums1[i], nums2[j]])
            k = k -1

            if j+1 < len(nums2):
                hq.heappush(heap, (nums1[i]+nums2[j+1], i, j+1))

        return res
