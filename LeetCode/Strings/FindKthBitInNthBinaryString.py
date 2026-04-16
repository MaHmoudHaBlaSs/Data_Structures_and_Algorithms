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


class Solution:
    def constructString(self, n: int) -> List:
        if n == 1:
            return ['0']

        prev = self.constructString(n-1)
        curr = prev[:]

        curr.append('1')
        prev.reverse()
        curr.extend(['1' if c == '0'else '0' for c in prev])
        return curr

    def findKthBit(self, n: int, k: int) -> str:
        return self.constructString(n)[k-1]