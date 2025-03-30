https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0;
        double max = Double.NEGATIVE_INFINITY;
        double sum = 0;
        while (right < nums.length) {
            while (right - left < k && right < nums.length) {
                sum += nums[right++];
            }
            if(right - left == k){
                max = Math.max(max, sum / (right - left))  ;
                sum -= nums[left++] ;
            }

        }
        return max;
    }
}
