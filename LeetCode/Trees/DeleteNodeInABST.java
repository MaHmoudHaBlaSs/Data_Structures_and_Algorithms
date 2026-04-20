// https://leetcode.com/problems/delete-node-in-a-bst/description/

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

       
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            // Case 1 : No childs , one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 2 : 2 childs -> solved by "Inorder Successor"
            root.val = minValue(root.right);

            // Delete Inorder Successor Node
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }
    public int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }
}