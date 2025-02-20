// https://leetcode.com/problems/balanced-binary-tree/

class Solution {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balanced;
    }
    public int getHeight(TreeNode node){
        if (node == null) return 0;
        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);
        if (Math.abs(leftH-rightH) > 1) balanced = false;
        return 1 + Math.max(leftH, rightH);
    }
}
