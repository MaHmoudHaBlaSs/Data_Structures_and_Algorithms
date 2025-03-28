// https://leetcode.com/problems/find-peak-element/description/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;

        // T: O(Log(n))
        while (left <= right){
            int mid = (left+right)/2;

            if (left == mid)
                return (nums[left] > nums[right])?left:right;
            if ((nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]))
                return mid;  
            if (nums[mid-1] > nums[mid]){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        // Arbitary Return Statement, Will never reached for valid inputs.
        return -1;
    }
}
