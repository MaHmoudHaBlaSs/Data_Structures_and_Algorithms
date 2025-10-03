/// https://leetcode.com/problems/stone-game-viii/description/

class Solution {
    private int[] prefix , dp; 

    private int maxScore(int x){
        if(x == prefix.length-1) return prefix[x];
        if(x == prefix.length) return 0;

        if(dp[x] != -1) return dp[x];

        int next = maxScore(x+1);

        return dp[x] = Math.max(next, prefix[x] - next);
    }
    
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        prefix =  new int[n+1]; dp = new int[n+1];

        for(int i=0; i<n; ++i){
            prefix[i+1] = prefix[i] + stones[i];
            dp[i+1] = -1;
        }   

        return maxScore(2);
    }
}