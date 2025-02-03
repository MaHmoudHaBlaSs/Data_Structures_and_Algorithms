// https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;

        for (int i = 0; i < nums.length && i <= right; i++){
            int temp;
            if (nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
            if (nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
                i--;
            }
        }
    }
}
