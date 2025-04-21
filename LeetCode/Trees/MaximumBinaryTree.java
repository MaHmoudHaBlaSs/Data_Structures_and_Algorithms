///   https://leetcode.com/problems/maximum-binary-tree/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums,0,nums.length);
    }

    private TreeNode solve(int[] nums,int start,int end){
        if(start >= end  ) return null; 
        int maxIndex = start;
        
        for(int i = start; i < end; i++)
            if(nums[i] > nums[maxIndex]) 
                maxIndex = i;
        

        return new TreeNode(nums[maxIndex], solve(nums, start, maxIndex),solve(nums, maxIndex + 1, end));
    } 
}