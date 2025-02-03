// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        
        while (left < right){
            int mid = (left+right)/2;
            int sum = nums[left]+nums[right];

            if (sum > target)
                right--;
            else if (sum < target)
                left++;
            else 
                return new int[]{left+1, right+1};
        }
        return new int[]{-1,-1};
    }
}
