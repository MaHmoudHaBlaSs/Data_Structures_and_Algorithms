// https://leetcode.com/problems/maximum-subarray/

// Kadane's Algorithm
// T: O(n)           S: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++){
            // Deside to start New sum or Extend the current sum 
            currSum = Math.max( nums[i], currSum + nums[i]);
            // Updated Max Sum when new max value reached
            maxSum = Math.max(maxSum, currSum); 
        }
        return maxSum;
    }
}