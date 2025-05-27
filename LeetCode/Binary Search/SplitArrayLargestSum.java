///  https://leetcode.com/problems/split-array-largest-sum/description/
/*
- The minimum possible largest sum is max(nums) (when k = nums.length).
- The maximum possible largest sum is sum(nums) (when k = 1).
- Find the smallest mid such that the array can be split into k subarrays where each subarray sum <= mid.
*/

class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Integer.MIN_VALUE, right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int ans = Integer.MIN_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            int result = canSplit(nums,k, mid);
            
            if(result != -1){
                ans = result;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }

        return ans;
    }

    private int canSplit(int[] nums, int k, int bound){
        int sum = 0,maxSum = Integer.MIN_VALUE, subArrays = 1;

        for(int i = 0; i<nums.length && subArrays <= k; i++){
            if(sum + nums[i] <= bound) {
                sum += nums[i];
            }
            else {
                subArrays++;
                sum = nums[i];
            }

            maxSum = Math.max(maxSum, sum);
        }
        
        return subArrays > k ? -1 : maxSum;
    }
}