// https://leetcode.com/problems/binary-tree-level-order-traversal-ii

// Same as Level Order Traversal but with reversing the result
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> levels = new LinkedList<>();
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--){
                TreeNode polled = queue.poll();
                level.add(polled.val);

                if (polled.left != null) queue.add(polled.left);
                if (polled.right != null) queue.add(polled.right);
            }
            levels.add(level);
        }

        Collections.reverse(levels);
        return levels;
    }
}