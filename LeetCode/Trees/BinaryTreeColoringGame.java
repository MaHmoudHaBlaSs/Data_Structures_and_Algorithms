///  https://leetcode.com/problems/binary-tree-coloring-game/

class Solution {
    private int leftSize = 0, rightSize = 0, x = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        size(root);

        return (leftSize > n/2) || (rightSize > n/2) || (n - leftSize - rightSize -1) > n/2 ;
    }

    private int size(TreeNode root){
        if(root == null) return 0;

        int left = size(root.left), right = size(root.right); 

        if(root.val == x) {
            leftSize = left;
            rightSize = right; 
        }

        return left + right + 1;
    }
}