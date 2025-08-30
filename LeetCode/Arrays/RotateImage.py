## https://leetcode.com/problems/rotate-image

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)

        # Transpose
        for i in range(n):
            for j in range(i+1, n):
                tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp
        
        # Reverse
        for col in range(n//2):
            for row in range(n):
                tmp = matrix[row][col]
                matrix[row][col] = matrix[row][n-col-1]
                matrix[row][n-col-1] = tmp