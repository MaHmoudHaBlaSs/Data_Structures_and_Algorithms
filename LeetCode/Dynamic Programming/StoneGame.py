# https://leetcode.com/problems/stone-game

# Same problem as PredictTheWinner look at its solution.
class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)
        dp = [[-1 for _ in range(0, n)] for _ in range(0, n)]

        def play(left, right):
            if left == right:
                dp[left][right] = piles[left]
                return dp[left][right]

            if dp[left][right] != -1:
                return dp[left][right]

            left_pick = piles[left] + play(left + 1, right)
            right_pick = piles[right] + play(left, right - 1)
            dp[left][right] = max(left_pick, right_pick)
            return dp[left][right]

        return play(0, n) > 0 