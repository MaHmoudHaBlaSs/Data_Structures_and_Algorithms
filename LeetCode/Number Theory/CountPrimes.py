# https://leetcode.com/problems/count-primes/description/

# TAKE A LOOK -> https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 3 : 
            return 0
        # Create is prime array
        is_prime = [True] * n
        is_prime[0] = is_prime[1] = False

        # Sieve of Eratosthenes
        for i in range(2, int(n**0.5) + 1):
            if is_prime[i]:
                for j in range(i*i, n, i):
                    is_prime[j] = False

        # Count primes
        return sum(is_prime)

