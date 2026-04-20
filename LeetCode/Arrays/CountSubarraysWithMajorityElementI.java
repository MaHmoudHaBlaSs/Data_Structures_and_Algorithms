// https://leetcode.com/problems/count-subarrays-with-majority-element-i/description/

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int targetCount = 0;
            for (int j = i; j < n; j++) {
                targetCount += (nums[j] == target) ? 1 : -1;

                // target appears more than 50% of the time
                if (targetCount > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}