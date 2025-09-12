## https://leetcode.com/problems/rotating-the-box

# T: O(n*m)
class Solution:
    def rotateTheBox(self, boxGrid: List[List[str]]) -> List[List[str]]:
        n = len(boxGrid)
        m = len(boxGrid[0])
        rotated = [[0 for _ in range(n)] for _ in range(m)] # m * n

        for i in range(n):
            for j in range(m):
                rotated[j][n-i-1] = boxGrid[i][j]

        for j in range(n):
            gaps = 0

            for i in range(m-1, -1, -1):
                if rotated[i][j] == '.':
                    gaps += 1
                elif rotated[i][j] == '*':
                    gaps = 0
                else:
                    if gaps > 0:
                        rotated[i + gaps][j] = '#'
                        rotated[i][j] = '.'

        return rotated