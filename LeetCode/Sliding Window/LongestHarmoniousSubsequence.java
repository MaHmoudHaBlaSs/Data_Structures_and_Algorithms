https://leetcode.com/problems/longest-harmonious-subsequence/description/?envType=problem-list-v2&envId=sliding-window

class Solution {
    public int findLHS(int[] nums) {
        int left = 0, right = 1 , res =0;
        Arrays.sort(nums);
        while(right < nums.length){
            int diff = nums[right] - nums[left];
            if (diff == 1) {
                res = Math.max(res, right - left + 1);
                right++;
            } else if (diff < 1) {
                right++;
            }else{
                left++;
            }
        }
        return res;

    }
}
