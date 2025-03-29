https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, res = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++]; 
            while (sum >= target) { 
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
