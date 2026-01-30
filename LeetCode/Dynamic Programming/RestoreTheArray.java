///  https://leetcode.com/problems/restore-the-array/description/


class Solution {
    private static final long MOD = 1_000_000_007L;
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        
        for(int i=n-1; i>=0; --i){
            if(s.charAt(i) == '0') continue;

            long current = 0, val = 0;

            for(int j=i; j<n; ++j){
                current *= 10;
                current += s.charAt(j) - '0';
                
                while(current<MOD && j+1 < n && s.charAt(j+1) == '0') {
                    current *= 10;
                    ++j;
                }
                
                if(current > k) break;
                
                val = (val + dp[j+1]) % MOD;
            }
            
            if(val == 0) return 0;
            dp[i] = (int)val; 
        }
        
        return dp[0];
    }
}