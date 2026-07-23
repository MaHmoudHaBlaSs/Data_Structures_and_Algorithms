#   https://leetcode.com/problems/shift-2d-grid/description/

class Solution:
    def shiftGrid(self, grid: list[list[int]], k: int):
        m = len(grid)
        n = len(grid[0])
        total_elements = m * n
        
        k = k % total_elements  # Handle cases where k is larger than the total number of elements

        flat_list = [grid[i][j] for i in range(m) for j in range(n)]

        
        shifted_list = flat_list[-k:] + flat_list[:-k]

        reshaped_grid =[]
        for i in range(m):
            row = shifted_list[i * n:(i + 1) * n]
            reshaped_grid.append(row)


        return reshaped_grid
        