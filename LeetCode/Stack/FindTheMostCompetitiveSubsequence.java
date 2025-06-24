///   https://leetcode.com/problems/find-the-most-competitive-subsequence/description/

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] stack = new int[k];
        int stackSize = 0;

        for (int i = 0; i < nums.length; i++) {
            while(stackSize > 0 && nums[i] < stack[stackSize-1] && nums.length - i >= k - stackSize + 1)
                stackSize--;

            if(stackSize < k) stack[stackSize++] = nums[i];
        }

        return stack;
    }
}