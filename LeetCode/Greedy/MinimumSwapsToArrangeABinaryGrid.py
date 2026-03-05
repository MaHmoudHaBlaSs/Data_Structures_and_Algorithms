#  https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/description/

class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        n = len(grid)
        freq = [0] * n

        for i in range(n):
            j = n - 1
            while j >= 0 and grid[i][j] == 0:
                j -= 1
            freq[i] = n - 1 - j

        ans = 0

        for i in range(n):
            required = n - i - 1

            if freq[i] >= required: continue

            j = i + 1
            while j < n and freq[j] < required:
                j += 1

            if j == n: return -1

            while j > i:
                freq[j], freq[j - 1] = freq[j - 1], freq[j]
                j -= 1
                ans += 1

        return ans