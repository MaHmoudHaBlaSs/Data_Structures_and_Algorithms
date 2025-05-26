// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

// The idea lays on we need to traverse the array in order of Right - Node - Left 
// T: O(n)          S: O(n)
class Solution {
    int cum = 0;

    public TreeNode bstToGst(TreeNode root) {
        TreeNode resTree = new TreeNode();
        customDfs(root, resTree);
        return resTree;
    }
    public void customDfs(TreeNode node, TreeNode newTree){
        if (node == null) return;

        if (node.right != null) newTree.right = new TreeNode();
        customDfs(node.right, newTree.right);
        cum += node.val;
        newTree.val = cum;

        if (node.left != null) newTree.left = new TreeNode();
        customDfs(node.left, newTree.left);
    }
}
