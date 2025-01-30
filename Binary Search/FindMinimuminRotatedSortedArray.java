// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left <= right){
            int mid = (left+right)/2;

            // Break Condition, also Handle not-rotated passed array
            if (nums[left] <= nums[right])
                return nums[left];
            // Check if mid belongs to left side or to right side..
            if (nums[mid] >= nums[left]) // enter when it belongs to left side
                left = mid+1; // elimenate left side including mid
            else // enter when it belongs to right sider
                right = mid; // elimenate right side before mid (mid could be the target)
        }
        return -1; // Arbitary return statement [will never reached for valid input]
    }
}
