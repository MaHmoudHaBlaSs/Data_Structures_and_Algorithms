/// https://leetcode.com/problems/stone-game-iii/description/

class Solution {
    private int[] dp, stones;
    private final int oo = 0x3f3f3f3f;
    private int n;

    private int solve(int i, boolean alice){
        if(i >= n) return 0; 

        if(dp[i] != oo) return alice ? dp[i] : -dp[i]; 

        int ans = -oo;
        int sum=0;
        for(int j=0; j<3 && i+j<n; ++j){
            sum += stones[i+j];
            int next = solve(i+j+1, !alice);
            ans = Math.max(ans, sum + (alice? next : - next)); 
        }

        dp[i] = ans;

        return alice ?ans:-ans; 
    } 

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length; 
        stones = stoneValue; 
        dp = new int[n]; 
        Arrays.fill(dp, oo); 
        
        int diff = solve(0,true);
        if(diff > 0 ) return "Alice";
        if(diff < 0 ) return "Bob";

        return "Tie"; 
    }
}