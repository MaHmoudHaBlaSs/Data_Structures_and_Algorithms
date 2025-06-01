///  https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/

/*
State: dp[i][diff] number of subscequences contains contains elemnent i with diff from to i
Transition: dp[i][diff] = sum of (dp[j][diff] + 1) where diff = nums[i] - nums[j] && 0 <= j < i 
*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; i++)
            dp[i] = new HashMap<>();

        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                int count = dp[j].getOrDefault(diff, 0);
                ans += count;
                
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + count + 1);
            }
        }

        return ans;
    }

}