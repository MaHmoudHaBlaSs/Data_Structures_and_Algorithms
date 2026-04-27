///  https://leetcode.com/problems/longest-arithmetic-sequence-after-changing-at-most-one-element/description/

class Solution {
    public int longestArithmetic(int[] nums) {
        int n = nums.length;
        int forward = helper(nums);

        reverse(nums);
        int backward = helper(nums);

        return Math.max(forward, backward);
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    private int helper(int[] nums) {
        int n = nums.length;
        int ans = 2;

        for (int i = 0; i < n - 1; i++) {
            int j = i;

            int diff = nums[i + 1] - nums[i];
            boolean usedViolation = false;
            int violationIndex = -1;

            while (j + 1 < n) {
                int currentDiff = nums[j + 1] - nums[j];

                if (currentDiff == diff) {
                    j++;
                    continue;
                }

                if (!usedViolation && j + 2 < n && nums[j + 2] - nums[j] == 2 * diff) {
                    usedViolation = true;
                    violationIndex = j + 1;

                    j += 2;
                } else {
                    break;
                }
            }

            int length;

            if (usedViolation) {
                length = j - i + 1;
                i = violationIndex - 1;
            } else {
                if (j < n - 1) {
                    length = j - i + 2;
                } else {
                    length = j - i + 1;
                }

                i = j - 1;
            }

            ans = Math.max(ans, length);
        }

        return ans;
    }
}