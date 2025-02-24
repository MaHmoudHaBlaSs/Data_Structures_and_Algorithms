// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] pos = {-1, -1};
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] > target)
                right = mid-1;
            else if (nums[mid] < target)
                left = mid+1;
            else{
                int counter = mid;
                do
                    pos[0] = counter;
                while (counter-1 >= 0 && nums[counter] == nums[--counter]);
                counter = mid;
                do
                    pos[1] = counter;
                while (counter+1 < nums.length && nums[counter] == nums[++counter]);
                break;
            }
        }
        return pos;
    }
}
