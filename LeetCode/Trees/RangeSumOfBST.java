// https://leetcode.com/problems/range-sum-of-bst/?envType=problem-list-v2&envId=tree

// T: O(n)
class Solution {
    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) 
            return 0;
            
        if (node.val < low || node.val > high)
            return rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
        return node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
    }
}
