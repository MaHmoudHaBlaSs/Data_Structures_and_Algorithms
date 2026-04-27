/// https://leetcode.com/problems/count-commas-in-range-ii/description/


class Solution {
    public long countCommas(long n) {
        long ans = 0;
        int l = len(n);
        
        while(l > 3){
            long nextN = getNines(--l);
            ans += (l/3) * (n-nextN);
            n = nextN;
        }
        
        return ans; 
    }

    private int len(long n){
        int ans = 0;
        while(n>0){
            ans++; 
            n/=10;
        }

        return ans;
    }

    private long getNines(int n){
        long ans = 0, weight = 1;
        while(n-->0){
            ans += 9*weight;
            weight *= 10;
        }

        return ans;
    }
}
