# https://leetcode.com/problems/binary-tree-paths

class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        paths = []
        path = []

        def dfs(node, path):
            if node.left is None and node.right is None:
                path.append(str(node.val))
                paths.append('->'.join(path))
                del path[-1]
            
            path.append(str(node.val))

            if node.left is not None:
                dfs(node.left, path)
            
            if node.right is not None:
                dfs(node.right, path)
            
            del path[-1]
        
        dfs(root, path)
        return paths