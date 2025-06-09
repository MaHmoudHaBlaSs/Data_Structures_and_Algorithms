// https://leetcode.com/problems/sum-root-to-leaf-numbers

// Solution 1 [Optimal]

// T: O(n)         S: O(1)
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    // Pre-Order
    public void dfs(TreeNode node, int curr){
        if (node == null) return;
        if (node.left == null && node.right == null){
            sum += curr*10 + node.val;
            return;
        }
        
        dfs(node.left, curr*10 + node.val);
        dfs(node.right, curr*10 + node.val);
    }
}

// T: O(n)         S: O(Log(n))
class Solution {
    StringBuilder num = new StringBuilder();

    // Pre-Order
    public int sumNumbers(TreeNode node) {
        num.append(node.val);
        if (node.left == null && node.right == null) 
            return Integer.parseInt(num.toString());

        int num1 = (node.left != null)? sumNumbers(node.left): 0; 
        if (num1 != 0) num.deleteCharAt(num.length()-1);
        int num2 = (node.right != null)? sumNumbers(node.right): 0;
        if (num2 != 0) num.deleteCharAt(num.length()-1);

        return num1+num2;
    }
}