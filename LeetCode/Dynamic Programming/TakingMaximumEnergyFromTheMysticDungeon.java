///  https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/description/

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length; 
        int[] dp = new int[n];

        for(int i=0; i<n; ++i){
            dp[i] = energy[i];

            if(i >= k){
                dp[i] += Integer.max(0, dp[i-k]);
            }
        }   

        int ans = Integer.MIN_VALUE;
        for(int i=n-k; i<n; ++i){
            ans = Integer.max(ans, dp[i]);
        }
        
        return ans;
    }
}