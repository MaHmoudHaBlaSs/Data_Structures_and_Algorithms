// https://leetcode.com/problems/find-peak-element/description/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while (left <= right){
            int mid = (left+right)/2;

            if (left == mid)
                return (nums[left] >= nums[right])?left:right;

            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            else if (nums[mid] > nums[mid-1])
                left = mid;
            else 
                right = mid;
        }
        // Arbitary Return Statement, Will never reached for valid inputs.
        return -1;
    }
}
