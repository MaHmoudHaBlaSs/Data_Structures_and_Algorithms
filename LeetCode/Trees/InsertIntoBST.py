#https://leetcode.com/problems/insert-into-a-binary-search-tree/

class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        def insert(node):
            if val > node.val:
                if node.right is None: 
                    node.right = TreeNode(val)
                else:
                    insert(node.right)
            else:
                if node.left is None:
                    node.left = TreeNode(val)
                else:
                    insert(node.left)
                

        if root is None: return TreeNode(val)
        insert(root)
        return root