// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/

class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n1 = (nums[0] - 1 ) * (nums[1] - 1 );
        int n2 = (nums[nums.length-1] - 1 ) * (nums[nums.length-2] - 1 );
        return n1 > n2 ? n1 : n2;
    }
}