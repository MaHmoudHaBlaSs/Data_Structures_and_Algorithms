// https://leetcode.com/problems/remove-element/description/

class Solution {
    public int removeElement(int[] nums, int val) {
        int r = nums.length - 1;
        int l = 0;
        
        while (l <= r) {
            while (r >= 0 && nums[r] == val) r--;
            
            if (l > r) break;
            
            if (nums[l] == val) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            }
            
            l++;
        }
        
        return r + 1;
    }
}