## https://leetcode.com/problems/n-ary-tree-preorder-traversal

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None: return None
        res = []
        stack = [root]

        while stack:
            nxt = stack.pop()
            res.append(nxt.val)

            for child in reversed(nxt.children):
                stack.append(child)
        
        return res