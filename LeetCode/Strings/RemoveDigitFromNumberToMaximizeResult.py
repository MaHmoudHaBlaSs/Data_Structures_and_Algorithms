# https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/

class Solution:

    def removeDigit(self, number: str, digit: str) -> str:
        res = 0

        for i, char in enumerate(number):
            if ( char == digit ):
                tmp = number[:i] + number[i+1:]
                res = max(res, int(tmp))

        return str(res)