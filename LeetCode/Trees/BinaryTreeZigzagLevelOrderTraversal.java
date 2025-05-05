// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

// T: O(n)              S: O(0.5n) [queue worst size (with leaf nodes)]
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        
        // true even traversal , false odd traversal
        boolean dir = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();

            // Normal BFS implementation just add right before left to the queue.
            for (int i = queue.size()-1; i >= 0; i--){
                
                TreeNode popped = queue.poll();
                level.add(popped.val);

                if (popped.right != null) queue.add(popped.right);
                if (popped.left != null) queue.add(popped.left);
            }
            if (dir) Collections.reverse(level); // reverse when even 
            dir = !dir;

            levels.add(level);
        }
        return levels;
    }
}