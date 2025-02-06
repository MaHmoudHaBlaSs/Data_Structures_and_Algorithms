// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while (nums[left] > nums[right]){
            int mid = (left+right)/2;

            if (nums[left] <= nums[mid]) // Mid belongs to left
                left = mid+1;
            else // Mid belongs to right
                right = mid;
        }
        return nums[left];
    }
}
