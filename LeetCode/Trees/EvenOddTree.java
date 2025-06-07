///  https://leetcode.com/problems/even-odd-tree/description/

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>(); 
        boolean isOdd = true;
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode prev = null;
            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

                if(isOdd) {
                    if((node.val & 1 ) == 0 || (prev != null && node.val <= prev.val)) 
                        return false;
                } else {
                    if((node.val & 1) == 1 || (prev != null && node.val >= prev.val)) 
                        return false;
                }
                prev = node;
            }
            isOdd = !isOdd;
        }
        
        return true;
    }
}