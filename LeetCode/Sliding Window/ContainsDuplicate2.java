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

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if (i > k)
                window.remove(nums[i - k - 1]); // Shrink

            if (window.contains(nums[i]))
                return true;

            window.add(nums[i]); // Expand
        }
        return false;
    }
}