// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxLevelSum = Integer.MIN_VALUE;
        int currLevel = 1;
        int maxLevel = 1;
        
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int currLevelSum = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                currLevelSum += node.val;
                if(node.left != null ) queue.offer(node.left);
                if(node.right != null ) queue.offer(node.right);
            }
            if(currLevelSum > maxLevelSum){
                maxLevel = currLevel;
                maxLevelSum = currLevelSum;
            }
            currLevel++;
        }
        return maxLevel;
        
    }
}