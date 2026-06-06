///  https://leetcode.com/problems/last-remaining-integer-after-alternating-deletion-operations/description/

class Solution {
    public long lastInteger(long n) {
        return solve(1,n,n,true);
    }

    private long solve(long start, long end, long n, boolean op1){
        if(start==end) return end;

        long step = (end-start)/(n-1);
        if(n%2==0){
            if(op1){
                return solve(start, end-step, n>>1, !op1);
            }
            else{
                return solve(start+step, end, n>>1, !op1);
            }
        }
        else{
            return solve(start, end, n-(n>>1), !op1);
        }
    }
}