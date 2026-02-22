#  https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/

class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        freq = [0] * k

        for n in arr: freq[n%k] += 1
        
        for i in range(1, (k//2) + 1):
            if freq[i] != freq[k-i]:
                return False

        return freq[0] % 2 == 0
        