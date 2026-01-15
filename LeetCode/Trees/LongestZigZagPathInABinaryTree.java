/// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/

class Solution {
    private int ans = 0;
    
    public int longestZigZag(TreeNode root) {
        traverse(root.left, true, 1);
        traverse(root.right, false, 1);
        return ans; 
    }

    private void traverse(TreeNode root, boolean right, int depth){
        if(root == null) {
            return; 
        }

        ans = Math.max(depth,ans);

        if(right){ 
            traverse(root.right, false, depth+1);
            traverse(root.left, true, 1);
        }
        else{ 
            traverse(root.left, true, depth+1);
            traverse(root.right, false, 1);    
        }
    }
}