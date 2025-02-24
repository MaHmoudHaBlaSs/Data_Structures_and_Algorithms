// https://leetcode.com/problems/subtree-of-another-tree/description/

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (subRoot == null) return true;
        if (isSametree(root, subRoot))
            return true;
        else 
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isSametree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root == null ^ subRoot == null) return false;
        if (root.val != subRoot.val) return false;  
        return isSametree(root.left, subRoot.left) && isSametree(root.right, subRoot.right);
    }
}
