// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertHelper(root , val);
    }
    public TreeNode insertHelper(TreeNode root, int element){

        if (root == null) return new TreeNode(element);
        
        if (root.val == element) return root;

        // Otherwise, recur down the tree
        if (element < root.val){
            root.left = insertHelper(root.left, element);
        }else{
            root.right = insertHelper(root.right, element);
        }

        
        return root;
    }
}