///  https://leetcode.com/problems/maximum-sum-circular-subarray/

/*
Using Kadane's algorithm: maximum circular subarray sum will be max(maxSubarraySum, totalSum - minSubarraySum)
*/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = nums[0] , n = nums.length, finalMax = nums[0];
        int sum=nums[0], finalMin = nums[0], currentMin = nums[0];

        for(int i=1;i<n;i++){
            sum += nums[i];
            currentMax = Math.max(nums[i], currentMax + nums[i]); 
            currentMin = Math.min(nums[i], currentMin + nums[i]); 

            if(currentMax > finalMax)
                finalMax = currentMax;  

            if(currentMin < finalMin)
                finalMin = currentMin;           
        }

        return Math.max(finalMax, sum-finalMin == 0 ? finalMax : sum-finalMin);
    }
}