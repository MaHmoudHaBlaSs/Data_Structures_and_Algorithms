#  https://leetcode.com/problems/get-the-maximum-score/description/

# Timeand and space: O(N1 + N2) 
class Solution:
    def maxSum(self, nums1: List[int], nums2: List[int]) -> int:
        n1, n2 = len(nums1), len(nums2)
        dp1, dp2 = [-1] * n1, [-1] * n2
        MOD = 1_000_000_007

        def solve1(i,j):
            if i >= n1: return 0
            if dp1[i] != -1: return dp1[i]

            while j < n2 and nums2[j] < nums1[i]:
                j += 1

            nxt = solve1(i+1, j)

            if j < n2 and nums1[i] == nums2[j]:
                nxt = max(nxt, solve2(i, j+1))

            dp1[i] = nums1[i] + nxt
            return dp1[i]
        
        def solve2(i,j):
            if j >= n2: return 0
            if dp2[j] != -1: return dp2[j]

            while i < n1 and nums1[i] < nums2[j]:
                i += 1

            nxt = solve2(i, j+1)

            if i < n1 and nums1[i] == nums2[j]:
                nxt = max(nxt, solve1(i+1, j))

            dp2[j] = nums2[j] + nxt
            return dp2[j]
        
        return max(solve1(0,0), solve2(0,0)) % MOD