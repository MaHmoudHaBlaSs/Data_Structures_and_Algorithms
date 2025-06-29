// https://leetcode.com/problems/find-pivot-index/description/


class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int totalSum = prefixSum[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int leftSum = (i == 0) ? 0 : prefixSum[i - 1];
            int rightSum = totalSum - prefixSum[i];

            if (leftSum == rightSum) return i;
            
        }

        return -1;
    }
}