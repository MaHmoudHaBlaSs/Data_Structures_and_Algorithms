///   https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/description/


class Solution {
    private static final long MOD = 1_000_000_007L;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n=horizontalCuts.length, m = verticalCuts.length;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = Math.max(horizontalCuts[0], h-horizontalCuts[n-1]) 
            , maxV = Math.max(verticalCuts[0], w-verticalCuts[m-1]); 

        for(int i=1; i<n; ++i)
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
        
        for(int i=1; i<m; ++i)
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i-1]);
               

        return (int)(((long)maxV * maxH) % MOD);
    }
}