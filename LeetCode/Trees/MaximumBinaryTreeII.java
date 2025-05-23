///    https://leetcode.com/problems/maximum-binary-tree-ii/        
/*

 It's required to append `val` at the end of In-Order [Left-Node-Right] traversl set and modify the tree to match a Max Tree
 so, by appending val to the set we already know that, the last sub traversal node would be [Left - Node] OR [Left - Node - Right]
 hence, `val` only has two options 1. is to be last most right node. 2. is to be a Node with no right branch.

 1. If the `val` isn't greater than the current node
    we will go to Right branch because it's not logical to go to left one as our 'val' is at last index in traversal set we mentioned
 2. If `val` found to be greater than current node we make new node and append the current node to its left branch

*/
// T: O(Log(n))              S: O(1)
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) 
            return new TreeNode(val, root, null); 

        // This assignment to handle later changes in the branch when base case reached.
        root.right = insertIntoMaxTree(root.right, val);

        return root;
    }
}