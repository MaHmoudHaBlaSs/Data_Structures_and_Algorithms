# https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/description/


class Solution:
    def minDays(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        visited = [[False]*m for i in range(n)]
        
        def dfs(r,c):
            visited[r][c] = True
            for (dx,dy) in dirs:
                x = r+dx
                y = c+dy

                if x >= 0 and x < n and y < m and y >= 0 and not visited[x][y] and grid[x][y] == 1:
                    dfs(x,y)


        def isConnected():
            count = 0

            for i,row in enumerate(grid):
                for j,cell in enumerate(row):
                    if cell == 1 and not visited[i][j]:
                        if count >= 1: 
                            return False
                        count += 1 
                        dfs(i,j)

            return count == 1
        

        if not isConnected():
            return 0
        
        for i,row in enumerate(grid):
            for j,cell in enumerate(row):
                if cell == 1:
                    grid[i][j] = 0
                    visited = [[False]*m for i in range(n)]
                    if not isConnected():
                        return 1
                    grid[i][j] = 1


        return 2 