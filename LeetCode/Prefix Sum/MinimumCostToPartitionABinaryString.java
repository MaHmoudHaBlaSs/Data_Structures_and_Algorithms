///  https://leetcode.com/problems/minimum-cost-to-partition-a-binary-string/description/


class Solution {
    public long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        int[] prefix = new int[n]; 
        
        if(s.charAt(0) == '1') prefix[0]=1;

        for(int i=1; i<n; ++i){
            prefix[i] = prefix[i-1] + (s.charAt(i) == '1'? 1:0);
        }

        return minCost(0,n-1, prefix, encCost, flatCost);
    }

    private long minCost(int l, int r, int[] prefix, int encCost, int flatCost){
        int len = r-l+1;
        if(len == 0) return 0;

        long x = prefix[r] - (l>0? prefix[l-1] : 0);
        long cost = x==0 ? flatCost : len * x * encCost;

        if((len&1) == 0){
            cost = Long.min(cost, 
                        minCost(l,l+(len/2)-1, prefix, encCost, flatCost) + 
                        minCost(l+ len/2, r, prefix, encCost, flatCost) 
                    );
        }

        return cost;
    }
}