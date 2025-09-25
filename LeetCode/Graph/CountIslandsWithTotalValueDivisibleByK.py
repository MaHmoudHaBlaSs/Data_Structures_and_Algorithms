# https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k

#   T: O(n)    S: O(n)
class Solution:

    def countIslands(self, grid: List[List[int]], k: int) -> int:
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        value = 0
        res = 0

        def dfs(grid, i, j):
            nonlocal value

            if (i >= len(grid) or i < 0 or j >= len(grid[0]) or j < 0 or grid[i][j] <= 0):
                return

            if (not visited[i][j]):
                value += grid[i][j]
                visited[i][j] = True

                dfs(grid, i+1, j)
                dfs(grid, i-1, j)
                dfs(grid, i, j+1)
                dfs(grid, i, j-1)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (not visited[i][j]) and grid[i][j] > 0:
                    dfs(grid, i, j)

                    if value % k is 0:
                        res += 1
                    value = 0
        return res
