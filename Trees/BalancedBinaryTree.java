// https://leetcode.com/problems/balanced-binary-tree/

class Solution {
    int diff = 0;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return (diff < 2);
    }
    public int dfs(TreeNode node){
        if (node != null){
            int leftH = dfs(node.left);
            int rightH = dfs(node.right);
            if (Math.abs(leftH - rightH) > diff)
                diff = Math.abs(leftH - rightH);
            return 1+Math.max(leftH, rightH);
        }
        else
            return 0;
    }
}
