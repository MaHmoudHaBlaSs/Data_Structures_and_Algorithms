// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/


// sorted array so we start from the mid index to take it as root 
// divide the problem to 2 sub problems and solve them in the same way 
// base case is low > high at this case there is no more avalible numbers in the array 

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }
    public TreeNode build(int [] nums , int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);
        return root;
    }
}