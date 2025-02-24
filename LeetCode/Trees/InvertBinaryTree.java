// https://leetcode.com/problems/invert-binary-tree/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return null;}
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
