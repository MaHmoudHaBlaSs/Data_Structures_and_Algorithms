// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/?envType=problem-list-v2&envId=greedy

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0 , l =0 , r = nums.length-1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            max = Math.max(max, sum);
            l++;
            r--;
        }
        return max;
    }
}