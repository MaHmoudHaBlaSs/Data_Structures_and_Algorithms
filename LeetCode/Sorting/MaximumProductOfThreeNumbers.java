// https://leetcode.com/problems/maximum-product-of-three-numbers/description/


class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n1 = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        int n2 = nums[0] * nums[1] * nums[nums.length-1];
        return n1 > n2 ? n1 : n2;

    }
}