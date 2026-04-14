// https://leetcode.com/problems/path-sum-iii/description/

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = 0 ;
        res += dfs(root, (long) targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right,targetSum);
        return res;
    }
    public int dfs(TreeNode root , Long remainingSum ){
        if(root == null )return 0;

        int count = 0;
        if(root.val == remainingSum){
            count = 1 ;
        }
        count += dfs(root.left,remainingSum-root.val);
        count += dfs(root.right,remainingSum-root.val);

        return count;


    }
}