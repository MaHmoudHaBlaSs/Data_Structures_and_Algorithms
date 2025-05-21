/// https://leetcode.com/problems/combination-sum-iv/description/

class Solution {
    private int[] dp;
    private int[] nums;
    
    private int ways(int target){
        if(target == 0) return 1;

        if(dp[target] != -1) return dp[target];
        
        int ans = 0;
        for(int num : nums){
            if(num <= target) 
                ans += ways(target-num);
        }

        return dp[target] = ans;  
    }

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1]; 
        this.nums = nums;  
        Arrays.fill(dp, -1); 

        return ways(target); 
    }
}