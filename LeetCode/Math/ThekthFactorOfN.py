#  https://leetcode.com/problems/the-kth-factor-of-n/description/

class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        small, large = [], []
        
        for i in range(1, int(math.isqrt(n)) + 1):
            if n % i == 0:
                small.append(i)
                if i != n // i:
                    large.append(n // i)
        
        factors = small + large[::-1]
        
        return factors[k-1] if k <= len(factors) else -1