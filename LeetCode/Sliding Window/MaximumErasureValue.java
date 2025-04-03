// https://leetcode.com/problems/maximum-erasure-value

// Optimal.
// T: O(n)          S: O(m) >> m is unique values
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0, sum = 0, max = 0;
        
        while (left <= right && right < nums.length){
            if (set.contains(nums[right])){
                while (set.contains(nums[right])){
                    set.remove(nums[left]);
                    sum -= nums[left];
                    left++;
                }
            }
            set.add(nums[right]);
            sum += nums[right];
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }
}