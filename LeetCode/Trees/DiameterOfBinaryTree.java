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
        dfs(root);
        return maxDiam;
    }
    public int dfs(TreeNode node){
        if (node == null) {return 0;}
        int left = dfs(node.left);
        int right = dfs(node.right);
        maxDiam = Math.max(maxDiam, left+right);
        return 1+Math.max(left, right);
    }
}
