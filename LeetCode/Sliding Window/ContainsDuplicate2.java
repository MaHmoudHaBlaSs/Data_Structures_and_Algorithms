https://leetcode.com/problems/contains-duplicate-ii/description/?envType=problem-list-v2&envId=sliding-window


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0 , right = 0;
        Set<Integer> uniqueNums = new HashSet<>();
        while (right < nums.length) {
            if (uniqueNums.contains(nums[right])) {
                return true;
            }

            uniqueNums.add(nums[right]);
            right++;

            
            if (right - left > k) {
                uniqueNums.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
