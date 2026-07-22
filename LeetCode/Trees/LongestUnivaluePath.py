#https://leetcode.com/problems/longest-univalue-path

class Solution:
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        self.max_streak = 0

        def dfs(node):
            if node is None:
                return 0

            left_estimate = dfs(node.left)
            right_estimate = dfs(node.right)

            left_path = 0
            right_path = 0

            if node.left and node.left.val == node.val:
                left_path = left_estimate + 1
            
            if node.right and node.right.val == node.val:
                right_path = right_estimate + 1

            self.max_streak = max(self.max_streak, left_path + right_path)
            return max(left_path, right_path)

        dfs(root)
        return self.max_streak