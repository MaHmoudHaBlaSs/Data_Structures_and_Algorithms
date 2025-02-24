// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

class Solution {
    // for recursion we call the function only one time whether to the right or to
    // the left so we are accessing level by level (height) which is log(n):
    // T: O(log(n)) 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {return root;} // Edge case
        if (p.val < root.val ^ q.val < root.val) {return root;} // Base case
        if (p.val < root.val) {return lowestCommonAncestor(root.left, p , q);}
        return lowestCommonAncestor(root.right, p , q);
    }
}
