///  https://leetcode.com/problems/maximum-multiplication-score/description/

class Solution {
    public long maxScore(int[] a, int[] b) {
        long[][] memo = new long[4][b.length];

        for(int i=0; i<4; ++i) Arrays.fill(memo[i], Long.MIN_VALUE);

        return solve(0,0, a, b, memo);
    }

    private long solve(int i, int j, int[] a, int[] b, long[][] memo){
        if(i >= 4) return 0;

        if(memo[i][j] != Long.MIN_VALUE) return memo[i][j];

        long ans = (long)a[i] * b[j] + solve(i+1, j+1, a, b, memo);

        if(b.length-j > 4-i) 
            ans = Long.max(ans, solve(i, j+1, a, b, memo));

        return memo[i][j] = ans;
    }
}