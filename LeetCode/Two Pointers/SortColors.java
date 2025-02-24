// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;

        // T: O(n)
        for (int i = 0; i <= right; i++){
            int temp = 0;
            if (nums[i] == 2){
                // Swap with Right and hold i
                temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;i--;
            } else if (nums[i] == 0){
                // Swap with Left
                temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
    }
}
