///  https://leetcode.com/problems/final-element-after-subarray-deletions/description/

class Solution {
    public int finalElement(int[] nums) {
        return Integer.max(nums[0], nums[nums.length-1]);
    }
}