///  https://leetcode.com/problems/maximum-score-of-a-good-subarray/description/

class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length, i = k, j = k;
        int currMin = nums[k], ans = nums[k];

        while (i > 0 || j < n - 1) {
            if (i == 0) {
                j++;
                currMin = Math.min(currMin, nums[j]);
            } else if (j == n - 1) {
                i--;
                currMin = Math.min(currMin, nums[i]);
            } else if (nums[i - 1] < nums[j + 1]) {
                j++;
                currMin = Math.min(currMin, nums[j]);
            } else {
                i--;
                currMin = Math.min(currMin, nums[i]);
            }
            ans = Math.max(ans, currMin * (j - i + 1));
        }
        return ans;
    }

}