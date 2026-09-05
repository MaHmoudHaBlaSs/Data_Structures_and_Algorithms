///  https://leetcode.com/problems/longest-square-streak-in-an-array/description/

class Solution {
    public int longestSquareStreak(int[] nums) {
        int ans = -1, n = nums.length;
        int[] dp = new int[n];

        Arrays.sort(nums);

        for(int i=n-1; i>=0; --i){
            int j = Arrays.binarySearch(nums, i+1, n, nums[i] * nums[i]);

            if(j < 0) dp[i] = 1;
            else{
                ans = Integer.max(ans, dp[i] = dp[j]+1);
            } 
        }

        return ans;
    }

}