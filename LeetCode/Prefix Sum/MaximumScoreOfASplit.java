///  https://leetcode.com/problems/maximum-score-of-a-split/description/

class Solution {
    public long maximumScore(int[] nums) {
        long sum = 0, ans = Long.MIN_VALUE;
        int min = nums[nums.length-1];

        for(int num : nums) sum += num;

        for(int i=nums.length-1; i>0; --i){
            min = Integer.min(min, nums[i]);
            sum -= nums[i];

            ans = Long.max(ans, sum-min);
        }

        return ans;
    }
}
