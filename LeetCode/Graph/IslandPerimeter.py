# https://leetcode.com/problems/island-perimeter

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        def isOutofBounds(i, j):
            return i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0])

        visited = [[False] * len(grid[0]) for _ in range(len(grid))]
        res = 0

        for x in range(len(grid)):
            for y in range(len(grid[x])):
                print(x, y)
                if grid[x][y] == 0:
                    continue
                    
                queue = [(x, y)]
                visited[x][y] = True

                while queue:
                    i, j = queue.pop(0)

                    for side in [(i, j + 1), (i + 1, j), (i - 1, j), (i, j - 1)]:
                        if isOutofBounds(*side) or grid[side[0]][side[1]] == 0:
                            print(side)
                            res += 1
                            continue

                        if not visited[side[0]][side[1]]:
                            queue.append(side)
                            visited[side[0]][side[1]] = True

                return res
            
        return 0