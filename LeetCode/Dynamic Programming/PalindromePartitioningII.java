///  https://leetcode.com/problems/palindrome-partitioning-ii/description/

/*
State: dp[n] is the min cuts to partition string with length n
Tarnsition: dp[n] = min(dp[n], dp[i-1] + 1) where substring(i to n) is palindrome
*/

class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0; 
        
        for(int n = 1; n <s.length(); n++){
            dp[n] = dp[n-1] + 1;
            for(int i=n-1; i>=0; i--){
                if(isPalindrome(s,i,n))
                    dp[n] = Math.min(dp[n], (i == 0? 0 : dp[i-1] + 1)); 
            }
        }
        
        return dp[s.length()-1];
    }

    private boolean isPalindrome(String st, int left, int right){
        while(left < right)
            if(st.charAt(left++) != st.charAt(right--)) 
                return false;
        
        return true;
    }
}