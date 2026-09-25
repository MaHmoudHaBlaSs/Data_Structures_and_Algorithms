# https://leetcode.com/problems/minimum-moves-to-convert-string/submissions/2132177729/

class Solution:
    def minimumMoves(self, s: str) -> int:
        moves = 0
        limit = 0

        for i in range(len(s)):
            if s[i] == 'X':
                if i >= limit:
                    moves += 1
                    limit = i + 3

        return moves

class Solution:
    def canConvertString(self, s: str, t: str, k: int) -> bool:
        used_moves = set()

        for i in range(len(s)):
            diff = (ord(t[i]) - ord(s[i])) % 26
            
            while diff in used_moves:
                diff += 26
                if diff > k:
                    return False
                
            used_moves.add(diff)

        return True