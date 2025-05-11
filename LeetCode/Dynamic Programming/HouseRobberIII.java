///  https://leetcode.com/problems/house-robber-iii/description/


//Time: O(N)          Space: O(N)
 class Solution {
    private HashMap<TreeNode, Integer> dp = new HashMap<>();

    public int rob(TreeNode root) {
        return solve(root);
    }

    private int solve(TreeNode root){
        if(root == null) return 0;
        if(dp.containsKey(root)) return dp.get(root); 

        int op1 = root.val;
        if(root.left != null) {
            op1 += solve(root.left.left);
            op1 += solve(root.left.right);    
        }
        if(root.right != null) {
            op1 += solve(root.right.left);
            op1 += solve(root.right.right);
        }

        int op2 = solve(root.left) + solve(root.right);
        dp.put(root, Math.max(op1, op2));  
        return Math.max(op1, op2);  
    }
}