///   https://leetcode.com/problems/predict-the-winner/description/

/*
Backtracking:
The max score player 1 can achieve is max of two options
    1-Take leftmost number `nums[i]` then let player 2 play optimally (let him choose between nums[i+1], nums[j])
        if player 2 chose nums[i+1] then next you will choose from nums[i+2] & nums[j].
        if player 2 chose nums[j] then next you will choose from nums[i+1] & nums[j-1].
    
    2-Take rightmost number `nums[j]` then let player 2 play optimally (let him choose between nums[i], nums[j-1])
        if player 2 chose nums[i] then next you will choose from nums[i+1] & nums[j-1].
        if player 2 chose nums[j-1] then next you will choose from nums[i] & nums[j-2].    
*/

//Time: O(2^n) 
class Solution {
    private int[] nums;
    private int[][] dp;

    private int solve(int i,int j){ //returns the maximum sum of numbers that player 1 can take
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int op1 = nums[i] + Math.min(solve(i+1,j-1), solve(i+2, j));
        int op2 = nums[j] + Math.min(solve(i+1,j-1), solve(i, j-2));

        return dp[i][j] = Math.max(op1, op2);
    }

    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        int sum = 0;
        for(int n : nums) sum += n;

        dp = new int[nums.length][nums.length];
        for(int i=0; i<nums.length; i++) Arrays.fill(dp[i], -1);
    
        int sol = solve(0,nums.length-1);
        return sol >= sum - sol;
    }
}