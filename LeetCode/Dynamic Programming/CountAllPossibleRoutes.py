#  https://leetcode.com/problems/count-all-possible-routes/description/


class Solution:
    def countRoutes(self, locations: List[int], start: int, finish: int, fuel: int) -> int:
        memo = {}
        MOD = 1_000_000_007

        def count(i, f):
            if (i,f) in memo:
                return memo[(i,f)]

            ans = 1 if i == finish else 0 

            for j,loc in enumerate(locations):
                remaining = f - abs(loc-locations[i])

                if j != i and remaining >= 0:
                    ans = (ans + count(j, remaining)) % MOD

            memo[(i,f)] = ans
            return ans

        return count(start, fuel) 