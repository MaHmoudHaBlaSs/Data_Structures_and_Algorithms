# https://leetcode.com/problems/modify-the-matrix/

class Solution:
    def modifiedMatrix(self, matrix: list[list[int]]) -> list[list[int]]:
        n = len(matrix)
        m = len(matrix[0])

        columnMaxs = [0] * m
        for j in range(m):
            for i in range(n):
                columnMaxs[j] = max(columnMaxs[j], matrix[i][j])

        for j in range(m):
            for i in range(n):
                if matrix[i][j] == -1:
                    matrix[i][j] = columnMaxs[j]

        return matrix   
