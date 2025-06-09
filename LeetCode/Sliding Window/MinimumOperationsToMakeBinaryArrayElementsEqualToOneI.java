// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i

// T: O(n)               S: O(1)
class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                flip(i, nums);
                operations++;
            }
        }
        return (nums[nums.length-1] == 1 && nums[nums.length-2] == 1)? operations: -1; 
    }

    public void flip(int i, int[] nums){
        if (nums.length - i <= 2) return;
        nums[i] ^= 1;
        nums[i+1] ^= 1;
        nums[i+2] ^= 1;
    }
}