///  https://leetcode.com/problems/count-elements-with-at-least-k-greater-values/description/

class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);

        int ans = 0, n = nums.length, j=0;

        for (int num : nums) {
            while (j < n && nums[j] <= num) {
                ++j;
            }

            if (n - j >= k) ans++;
            else break;
        }
        
        return ans;
    }
}