// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/


class Solution {

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;

        if (root.val % 2 == 0) {
            if (root.left != null) {
                sum += getChildrenSum(root.left); 
            }
            if (root.right != null) {
                sum += getChildrenSum(root.right);
            }
        }

        sum += sumEvenGrandparent(root.left);
        sum += sumEvenGrandparent(root.right);

        return sum;
    }
    public int getChildrenSum(TreeNode root){
        int sum = 0;
        if (root.left != null) {
            sum += root.left.val;
        }
        if (root.right != null) {
            sum += root.right.val;
        }
        return sum;
    }
    
}