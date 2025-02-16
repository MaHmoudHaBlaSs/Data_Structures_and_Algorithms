// https://leetcode.com/problems/binary-tree-right-side-view/description/

class Solution {
    // T: O(n)        S: O(n)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>(); queue.add(root);

        while (!queue.isEmpty()){
            TreeNode lastNode = null;

            for (int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                
                if (node == null) continue;
                lastNode = node;
                queue.add(node.left);
                queue.add(node.right);
            }
            if (lastNode != null) rightSide.add(lastNode.val);
        }
        return rightSide;
    }
}
