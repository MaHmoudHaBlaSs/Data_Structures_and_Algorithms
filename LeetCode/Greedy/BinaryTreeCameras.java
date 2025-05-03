///   https://leetcode.com/problems/binary-tree-cameras/description/


//Greedy thinking is to put a cam in the root only if one of it's children is not monitored.  

class Solution {
    private int count = 0;
    private final int WATCHED = 0, UN_WATCHED = 1, CONTAINS_CAM = 2; 
    
    public int minCameraCover(TreeNode root) {
        return getStatus(root) == UN_WATCHED ? count+1 : count;
    }

    private int getStatus(TreeNode root){
        if(root == null) return WATCHED; 

        int leftStat = getStatus(root.left);
        int rightStat = getStatus(root.right);
        
        if(leftStat == UN_WATCHED || rightStat == UN_WATCHED){
            count++;
            return CONTAINS_CAM;         
        }

        if(leftStat == CONTAINS_CAM || rightStat == CONTAINS_CAM)
            return WATCHED;

        return UN_WATCHED;
    }
}