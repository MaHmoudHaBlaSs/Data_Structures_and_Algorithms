///   https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/


public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean endFound = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {   
                endFound = true;
                continue;
            }

            if (endFound) //if any node has come after null, it will find 'endFound' = true and return false
                return false;
            

            queue.add(node.left);
            queue.add(node.right);
        }

        return true;
    }
}
