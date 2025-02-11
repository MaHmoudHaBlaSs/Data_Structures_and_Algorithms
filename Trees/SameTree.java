// https://leetcode.com/problems/same-tree/

class Solution {
    boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return isSame;
    }
    public void dfs(TreeNode p, TreeNode q){
        if (p != null && q != null){
            if (!isSame)
                return;
            isSame = p.val == q.val;
            dfs(p.left, q.left);
            dfs(p.right, q.right);
        } else if ((p == null && q != null) || (q == null && p != null)){
            isSame = false;
        }
    }
}
