// https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75


class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int count = 0, right = 0, zeroCount = 0;

        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && (zeroCount < k || nums[right] == 1)) {
                if (nums[right] == 0) {
                    zeroCount++;
                }
                right++;
            }

            count = Math.max(count, right - left);
            
            if (nums[left] == 0) {
                zeroCount--;
            }
        }

        return count;
    }
}