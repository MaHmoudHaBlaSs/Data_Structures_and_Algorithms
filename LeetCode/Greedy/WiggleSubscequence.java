///  https://leetcode.com/problems/wiggle-subsequence/description/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int positive = 1, negative = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) 
                positive = negative + 1;
            else if (nums[i] < nums[i - 1])
                negative = positive + 1;
        }

        return Math.max(positive, negative);
    }
}