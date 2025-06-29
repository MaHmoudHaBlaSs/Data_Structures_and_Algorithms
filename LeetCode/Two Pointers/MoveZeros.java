// https://leetcode.com/problems/move-zeroes/description/

class Solution {
    public void moveZeroes(int[] nums) {
        int sutibleIndex = 0 ;
        for (int i = 0 ; i < nums.length ; i ++){
            if(nums[i] != 0 ){
                nums[sutibleIndex] = nums[i];
                sutibleIndex++;
            }
        }
        for(int j = sutibleIndex ; j < nums.length ; j++){
            nums[j] = 0;
        }
        

    }
}