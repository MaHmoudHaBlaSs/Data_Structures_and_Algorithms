#  https://leetcode.com/problems/detect-cycles-in-2d-grid/description/


class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        directions = [(0,-1), (0,1), (1,0), (-1,0)]
        n, m = len(grid), len(grid[0])
        visited = [[False] * m for i in range(n)]

        def isCycle(x, y, parent):
            if visited[x][y]: 
                return True
            
            visited[x][y] = True

            for (dx,dy) in directions:
                newX, newY = x + dx, y + dy

                if newX < 0 or newX >= n or newY < 0 or newY >= m:
                    continue
                
                if (newX, newY) != parent and grid[x][y] == grid[newX][newY]: 
                    if isCycle(newX, newY, (x,y)):
                        return True
                    
            return False
        
        for x in range(n):
            for y in range(m):
                if not visited[x][y] and isCycle(x,y, (-1,-1)):
                    return True
                    
        return False
        