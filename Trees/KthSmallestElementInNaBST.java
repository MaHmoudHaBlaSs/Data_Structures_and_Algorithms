// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

class Solution {
    int kVal = 0, n = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return kVal;
    }
    public void inOrder(TreeNode node, int k){
        if (node == null) return;
        inOrder(node.left, k);
        if (++n == k) kVal = node.val;
        inOrder(node.right, k);
    }
}
