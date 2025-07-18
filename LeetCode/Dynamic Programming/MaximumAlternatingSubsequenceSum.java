/// https://leetcode.com/problems/maximum-alternating-subsequence-sum/description/

class Solution {
    private long[][] memo;
    private int[] nums;

    private long solve(int i,boolean even){
        if(i >= nums.length) return 0;

        int j = even ? 1 : 0;
        if(memo[j][i] != -1) return memo[j][i];

        long op1 = solve(i+1, !even) + (even ? nums[i] : -nums[i]); //take the current number
        long op2 = solve(i+1, even); //skip

        return memo[j][i] = Math.max(op1, op2);
    }

    public long maxAlternatingSum(int[] nums) {
        this.nums = nums;
        memo = new long[2][nums.length+1];

        Arrays.fill(memo[0], -1);
        Arrays.fill(memo[1], -1);

        return solve(0, true);
    }
}