/// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/

class Solution { 
    private int solve(int k, int i, int[][] events, int[][] dp){
        if(k == 0 || i >= events.length) return 0;

        if(dp[k][i] != -1) return dp[k][i];
        
        int op1 = solve(k, i+1, events, dp);
        
        int l=i+1, r=events.length-1, lastBusy = events[i][1], avIdx = -1;
        while(l<=r){
            int mid = (l+r) >> 1;
            if(events[mid][0] > lastBusy){
                avIdx = mid;
                r = mid-1;
            }
            else l = mid+1;
        }

        int op2 = events[i][2] + (avIdx == -1 ? 0 : solve(k-1, avIdx, events, dp));
        
        return dp[k][i] = Math.max(op1, op2);
    }

    public int maxValue(int[][] events, int k) {
        int[][] dp = new int[k+1][events.length];
        
        for(int i=1; i<=k; ++i) Arrays.fill(dp[i], -1);

        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        return solve(k,0,events, dp);
    }
}