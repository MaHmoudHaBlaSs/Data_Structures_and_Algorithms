// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

class Solution {
  // T: O(n)        S: O(n)
  public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>(); queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();

            for (int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();

                if (node == null) continue;
                queue.add(node.left);
                queue.add(node.right);
                
                level.add(node.val);
            }

            if (!level.isEmpty()) levelOrder.add(level);
        }
        return levelOrder;
    }
}
