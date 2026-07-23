/// https://leetcode.com/problems/number-of-stable-subsequences/description/

class Solution {
    private final long MOD = 1_000_000_007;
    private final int EVEN = 1, ODD = 0;

    public int countStableSubsequences(int[] nums) {
        long ans = 0;
        int[][][] dp = new int[nums.length][3][2];
        for(int i=0; i<nums.length; ++i){
            for(int j=1; j<3; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i=0; i<nums.length; ++i){
            int parity = ((nums[i] & 1) == 0) ? EVEN : ODD;

            ans = (ans + solve(i+1, nums, 1, parity, dp)) % MOD;
        }

        return (int)ans;
    }

    private int solve(int i, int[] nums, int count, int prev, int[][][] dp){
        if(i == nums.length) return 1;

        if(dp[i][count][prev] != -1) return dp[i][count][prev];

        long ans = solve(i+1, nums, count, prev, dp);
        int parity = ((nums[i] & 1) == 0) ? EVEN : ODD;

        if(parity == prev){
            if(count < 2){
                ans = (ans + solve(i+1, nums, count+1, prev, dp)) % MOD;
            }
        }else{
            ans = (ans + solve(i+1, nums, 1, parity, dp)) % MOD;
        }

        return dp[i][count][prev] = (int)ans;
    } 
}