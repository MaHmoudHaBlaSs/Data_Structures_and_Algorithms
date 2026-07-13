///  https://leetcode.com/problems/maximum-total-subarray-value-i/description/

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0], max = nums[0];

        for(int i=1; i<nums.length; ++i){
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        } 

        return (long)k * (max-min);
    }
}