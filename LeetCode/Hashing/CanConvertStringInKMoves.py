#  https://leetcode.com/problems/can-convert-string-in-k-moves/description/


class Solution:
    
    # Solution 1
    def canConvertString(self, s: str, t: str, k: int) -> bool:
        if len(s) != len(t): return False
        next_diff = [i for i in range(27)]

        for i in range(len(s)):
            diff = (ord(t[i]) - ord(s[i])) % 26
            if diff == 0: continue

            if next_diff[diff] > k: 
                return False
                
            next_diff[diff] += 26

        return True


    # Solution 2
    def canConvertString(self, s: str, t: str, k: int) -> bool:
        arr = [0] * 27
        n1, n2 = len(s), len(t)

        if n1 != n2: return False

        for i in range(n1):
            diff = ord(t[i]) - ord(s[i])

            if diff == 0: continue
            elif diff < 0: diff += 26

            shift = arr[diff]
            if diff + shift > k: return False

            arr[diff] +=  26

        return True