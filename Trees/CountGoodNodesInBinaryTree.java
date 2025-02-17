// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    // T: O(n)           S:O(n) >> Check for space complexity
    public int dfs(TreeNode node, int max){
        if (node == null) return 0;
        if (node.val >= max){
            return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
        }else{
            return 0 + dfs(node.left, max) + dfs(node.right, max);
        }
    }
}
