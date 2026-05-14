// https://leetcode.com/problems/deepest-leaves-sum/description/


class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSum = 0;

        while (!queue.isEmpty()) {
            levelSum = 0; 
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return levelSum; 
    }
}