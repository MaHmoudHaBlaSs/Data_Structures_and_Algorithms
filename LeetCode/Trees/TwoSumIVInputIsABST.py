# https://leetcode.com/problems/two-sum-iv-input-is-a-bst

# T: O(n^2)      S: O(n) >> recursive
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        seen = set()

        def dfs(node, k):
            if node is None:
                return False

            complement = k - node.val
            if complement in seen:
                return True
            seen.add(node.val)

            return dfs(node.left, k) or dfs(node.right, k)

        return dfs(root, k)