///   https://leetcode.com/problems/minimum-moves-to-balance-circular-array/description/

class Solution {
    public long minMoves(int[] balance) {
        long ans = 0;
        int ngtvIdx = -1, n = balance.length;
        for(int i=0; i<n; ++i){
            if(balance[i] < 0){
                ngtvIdx = i;
                break;
            } 
        }

        if(ngtvIdx == -1) return 0;

        balance[ngtvIdx] *= -1;

        for(int i=1; i <= (n>>1); ++i){
            int l=(ngtvIdx-i+n)%n, r=(ngtvIdx+i)%n;

            int transfer = Integer.min(l==r? balance[l] : balance[l] + balance[r], balance[ngtvIdx]);
            ans += (long)transfer * i;

            balance[ngtvIdx] -= transfer;

            if(balance[ngtvIdx] == 0) return ans;
        }

        return -1;
    }
}