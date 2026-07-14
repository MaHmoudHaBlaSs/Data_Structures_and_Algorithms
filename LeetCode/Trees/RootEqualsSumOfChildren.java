// https://leetcode.com/problems/root-equals-sum-of-children/description/

class Solution {
    public boolean checkTree(TreeNode root) {
        if (root == null) return false;
        int sum = 0;
        if (root.left != null) sum += root.left.val;
        if (root.right != null) sum += root.right.val;
        return sum == root.val;
    }
}