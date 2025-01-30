// https://leetcode.com/problems/find-peak-element/description/
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left <= right){
            int mid = (left+right)/2;

            if ((left == right) || (mid-1 == -1))
                return (nums[left] >= nums[right])?left:right;
            if (nums[mid] > nums[mid-1]){
                if (nums[mid] > nums[mid+1])
                    return mid;
                else // val of (mid+1) > val of (mid) 
                    left = mid+1;
            } else {
                right = mid-1;
            } 
        }
        // Arbitary return statement, it will never reached.
        return -1;
    }
}
