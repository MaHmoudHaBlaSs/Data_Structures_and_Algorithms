// https://leetcode.com/problems/validate-binary-search-tree/description/

class Solution {

    public boolean isValidBST(TreeNode root) {
        // used double instead of integer to avoid edge cases when node.val is equal to integer.max or min values
        // because Integer.max or min value could be possible value and can't be used as infinity 
        // so to simulate infinity value we use larger data type such long or double.
        return dfs(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    public boolean dfs(TreeNode node, double min, double max) {
        if (node == null) return true;
        if (!(node.val < max && node.val > min)) return false;
        // When going left update max condition and when going right update min condition
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max); 
    }
}
