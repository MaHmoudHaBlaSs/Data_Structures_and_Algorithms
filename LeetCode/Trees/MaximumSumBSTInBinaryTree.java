/// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/

class Solution {
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    private BSTSum traverse(TreeNode root){
        if(root == null) return new BSTSum(true,0,Integer.MAX_VALUE, Integer.MIN_VALUE);

        BSTSum left = traverse(root.left);
        BSTSum right = traverse(root.right);

        boolean canBeBST = true;
        if(root.left != null && root.val <= left.largest)
            canBeBST = false;
        if(root.right != null && root.val >= right.smallest)
            canBeBST = false;

        BSTSum res = new BSTSum(
            left.isBST && right.isBST && canBeBST,
            left.sum + right.sum + root.val,
            Math.min(root.val, left.smallest),
            Math.max(root.val, right.largest)
        );

        
        if(res.isBST) maxSum = Math.max(maxSum, res.sum);
        return res;
    }

    static class BSTSum{
        boolean isBST;
        int sum, smallest, largest;
        
        BSTSum(boolean isBST, int sum, int smallest, int largest){
            this.sum=sum;
            this.isBST = isBST;
            this.smallest = smallest;
            this.largest = largest;
        }
    }
}
