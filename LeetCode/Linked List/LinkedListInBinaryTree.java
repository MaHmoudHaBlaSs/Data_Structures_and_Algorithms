/// https://leetcode.com/problems/linked-list-in-binary-tree/description/

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        ArrayList<TreeNode> candidates = new ArrayList<>();
        
        traverse(root, candidates, head.val);

        for(var candidate : candidates){
            if(isSame(candidate, head)) return true;
        }

        return false;
    }

    private void traverse(TreeNode root, ArrayList<TreeNode> candidates, int val){
        if(root == null) return; 
        if(root.val == val) candidates.add(root);

        traverse(root.left, candidates, val);
        traverse(root.right, candidates, val);
    }

    private boolean isSame(TreeNode root, ListNode head){
        if(head == null) return true;

        if(root == null || head.val != root.val) return false;

        return isSame(root.left, head.next) || isSame(root.right, head.next);
    }
}