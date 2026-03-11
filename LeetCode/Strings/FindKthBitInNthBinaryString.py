#  https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/


class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        def reverseInvert(s: str):
            ans = ""
            l = len(s) - 1

            while l >= 0:
                digit = s[l] == '1'
                ans += int(not digit).__str__()
                l -= 1

            return ans

            

        def getS(i):
            if i == 1: return "0"
            prev = getS(i - 1)

            return prev + "1" + reverseInvert(prev)
        
        return getS(n)[k - 1]