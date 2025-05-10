// https://leetcode.com/problems/house-robber/description/

// Top-Down

class Solution {
    int []memory;
    public int rob(int[] nums) {
        memory = new int[nums.length];
        Arrays.fill(memory, -1);
        return  maxHouses(nums, 0) ;
    }
    public int maxHouses(int []nums , int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memory[i] != -1) {
            return memory[i];
        }
        memory[i] = Math.max(maxHouses(nums, i + 1), nums[i] + maxHouses(nums, i + 2));
        return memory[i];
    }
}