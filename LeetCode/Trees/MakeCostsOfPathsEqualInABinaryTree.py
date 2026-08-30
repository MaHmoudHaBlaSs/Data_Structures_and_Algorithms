#https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/description/

class Solution:
    # The core idea is to let each root node to settle its left and right subtree costs, 
    # by increasing the smaller subtree cost to match the larger one 
    # (we don't care which one is larger, we just need to make them equal).
    # them return the maximum cost (settled cost) of the current subtree to its parent node, and so on.

    # Bottom-Up-Tree DP (Post-order DP [left -> right -> root])   
    # Time: O(n) , Space: O(n) for recursion stack
    def minIncrements(self, n: int, cost: list[int]) -> int:
        res = 0

        def dfs(i: int) -> int:
            nonlocal res
            
            if ( i > n ):
                return 0

            left_cost = dfs(2 * i)
            right_cost = dfs(2 * i + 1)

            res += abs(left_cost - right_cost)
            return max(left_cost, right_cost) + cost[i-1] # cost is 0-indexed

        dfs(1)
        return res