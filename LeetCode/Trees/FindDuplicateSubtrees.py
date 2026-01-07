## https://leetcode.com/problems/find-duplicate-subtrees/

# You should return all distinct duplicate subtrees, Each unique structure that appears more than once in the entire tree
# But only one instance per duplicate pattern.

class Solution:
        # Time: O(n)              Space: O(n)
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        key_to_id = {}
        id_to_freq = {}
        res = []

        def dfs(node):
            if node is None:
                return 0

            # Post-Order DFS
            left_id = dfs(node.left)
            right_id = dfs(node.right)

            # Each node is identified by its value, left node id and right node id
            key = tuple([node.val, left_id, right_id]) 
            key_to_id[key] = key_to_id.setdefault(key, len(key_to_id) + 1) # Dictionary searches by tuple value not reference
            node_id = key_to_id[key]

            freq = id_to_freq[node_id] = id_to_freq.get(node_id, 0) + 1
            
            if freq == 2: # Not greater than 2, to avoid adding samd duplicates
                res.append(node)

            return node_id

        dfs(root)
        return res

    # ------------------------------------------- Serialization Solution (Bad for this Case) -------------------------------------- #

    # Time: Huge Thing              Space: O(n)
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        serials = {}
        duplicate_serials = set()
        res = []

        # Preorder Serialization
        def serialize(node, serial):
            if node is None:
                serial.append('#,')
                return
            serial.append(str(node.val)+',')

            serialize(node.left, serial)
            serialize(node.right, serial)

        def dfs(node):
            nonlocal serials

            if node is None:
                return

            serial = []
            serialize(node, serial)
            str_serial = "".join(serial)

            if (str_serial in serials) and (str_serial not in duplicate_serials):
                res.append(node)
                duplicate_serials.add(str_serial)
            else:
                serials[str_serial] = node

            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return res