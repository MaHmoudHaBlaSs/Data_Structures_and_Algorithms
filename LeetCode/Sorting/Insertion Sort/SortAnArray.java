// problem_Link = https://leetcode.com/problems/sort-an-array/description/

class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 1 ; i<nums.length ; i++){
            int current = nums[i];
            int j = i-1;
            while(j>=0 && current < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = current ;
        }
        return nums;
    }
}
