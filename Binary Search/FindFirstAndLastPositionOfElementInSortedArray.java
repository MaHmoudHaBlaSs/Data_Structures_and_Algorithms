// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int[] pos = new int[2];

        while (left <= right){
            int mid = (left+right)/2;

            if (target < nums[mid])
                right = mid-1;
            else if (target > nums[mid])
                left = mid+1;
            else {
                int i = mid;
                while ((i >= 0) && (nums[i] == target)){
                    i--;
                }
                pos[0] = i+1; 
                i = mid;
                while ((i <= nums.length-1) && (nums[i] == target)){
                    i++;
                }
                pos[1] = i-1;
                return pos;
            }
        }
        return new int[]{-1, -1};
    }
}
