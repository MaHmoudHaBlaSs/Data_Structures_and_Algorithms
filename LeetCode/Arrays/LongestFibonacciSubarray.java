// https://leetcode.com/problems/longest-fibonacci-subarray/description/

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int maxLen = 2;
        int currentLen = 2;

        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1] + nums[i - 2]) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 2;
            }
        }

        return maxLen;
    }
}