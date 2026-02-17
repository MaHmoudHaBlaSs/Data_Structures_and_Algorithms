///  https://leetcode.com/problems/paint-house-iii/description/

class Solution {
    private static final int oo = 0x3f3f3f3f;
    private int[][][] memo;
    private int[][] cost;
    private int n,m;

    private int solve(int i, int target, int[] houses, int prevColor){
        if(target < 0 || (i==m && target > 0)) return oo;
        if(i == m) return 0;

        if(memo[i][target][prevColor] != -1) return memo[i][target][prevColor];

        int ans = oo;

        if(houses[i] != 0)
            return memo[i][target][prevColor] = solve(i+1, houses[i]==prevColor? target : target-1, houses, houses[i]);

        for(int j=1; j<=n;  j++){
            houses[i] = j;
            ans = Math.min(ans, cost[i][j-1] + solve(i+1, j==prevColor ? target : target-1, houses, j));
            houses[i] = 0;
        }

        return memo[i][target][prevColor] = ans;
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.n = n; this.m = m;; this.cost = cost;
        memo = new int[m][target+1][n+1];
        for(int i=0; i<m; i++)
            for(int j=0; j<target+1; j++) Arrays.fill(memo[i][j], -1);

        int ans = solve(0, target, houses,0);
        return ans == oo ? -1 : ans;
    }    
}
