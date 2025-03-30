// https://leetcode.com/problems/path-sum/

// Optimal.
// T: O(n)            S: O(1)
class Solution {
    int sum = 0;
    boolean hasSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return hasSum;
    }
    public void dfs(TreeNode node, int target){
        if (node == null) return;
        sum += node.val;

        if (sum == target && node.left == null && node.right == null) {
            hasSum = true;
            return;    
        }
        
        dfs(node.left, target);
        dfs(node.right, target);
        sum -= node.val;
    }
}