///   https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/description/

/*
Minimum number of removals = n - maximum number of elements that form a mountain array
The max elements to form a mountain is (longest increasing subscequence from 0 to i  + logngest decressing subscequence form i to n-1) 
where 0 < i < n-1
*/

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length; 
        if(n == 3) return 0;
        
        int ans = n - 3;
        int[] dp = new int[n]; 

        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(nums[j] < nums[i]) 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        for(int i=n-1; i>0; i--){
            int increasing = dp[i];
            dp[i] = 1;
            
            for(int j=i+1; j<n; j++){
                if(nums[j] < nums[i]) 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            
            if(increasing > 1 && dp[i] > 1)
                ans = Math.min(ans, n-(dp[i]+increasing-1));
        }
        
        return ans; 
    }
}