#  https://leetcode.com/problems/stone-game-iv/description/

class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        memo = [-1] * (n + 1)
        
        def canWin(x):
            if x == 0:
                return False
            if memo[x] != -1:
                return memo[x]
            
            i = 1
            while i*i <= x:
                if not canWin(x - i*i):
                    memo[x] = True
                    return True
                i += 1
            
            memo[x] = False
            return False
        
        return canWin(n)