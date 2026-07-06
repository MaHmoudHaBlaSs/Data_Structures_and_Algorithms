// https://leetcode.com/problems/find-bottom-left-tree-value/description/


class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int bottomLeftValue = root.val;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            bottomLeftValue = queue.peek().val; 

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return bottomLeftValue;
    }
}