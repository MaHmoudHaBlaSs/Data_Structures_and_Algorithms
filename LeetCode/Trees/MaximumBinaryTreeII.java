///    https://leetcode.com/problems/maximum-binary-tree-ii/        


class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) 
            return new TreeNode(val, root, null); 

        root.right = insertIntoMaxTree(root.right, val);

        return root;
    }
}