// https://leetcode.com/problems/diameter-of-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDiam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxH(root);
        return maxDiam;
    }
    public int getMaxH(TreeNode node){
        if (node != null){
            int leftH = getMaxH(node.left);
            int rightH = getMaxH(node.right);
            if (leftH+rightH > maxDiam)
                maxDiam = leftH+rightH;
            return 1+Math.max(leftH, rightH);
        }
        else
            return 0;
    }
}
