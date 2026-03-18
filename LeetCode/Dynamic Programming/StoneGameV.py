#  https://leetcode.com/problems/stone-game-v/description/

# Time & Space: O(N^2)
class Solution:
    def stoneGameV(self, stoneValue: List[int]) -> int:
        n = len(stoneValue)
        dp = [[-1]*n for i in range(n)]
        prefix = [0] * (n+1)

        for idx in range(n):
            prefix[idx+1] = prefix[idx] + stoneValue[idx]

        def solve(start, end):
            if end - start < 1: 
                return 0

            if dp[start][end] != -1: 
                return dp[start][end]
            
            prev = prefix[start]
            rangeSum = prefix[end+1]-prev
            
            ans, i = 0, start
            while i < end:
                leftSum = prefix[i+1] - prev
                rightSum = rangeSum - leftSum

                if leftSum < rightSum:
                    ans = max(ans, leftSum + solve(start, i))
                elif leftSum > rightSum:
                    ans = max(ans, rightSum + solve(i+1, end))
                else: 
                    ans = max(ans, leftSum + solve(start, i), leftSum + solve(i+1, end))

                i += 1

            dp[start][end] = ans
            return ans
        

        return solve(0,n-1)
