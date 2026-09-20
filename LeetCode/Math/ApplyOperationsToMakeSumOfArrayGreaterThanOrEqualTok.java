///  https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/description/

class Solution {
    public int minOperations(int k) {
        if(k == 1) return 0;
        
        int LHS = k-1, RHS = (int)Math.ceil(k/2);
        int x = 1;

        while(LHS >= RHS){
            x++;

            LHS = (int)Math.ceilDiv(k,x) - 1;
            RHS = (int)Math.ceilDiv(k,x+1);
        }

        return (x-1) + (int)Math.ceilDiv((k-x), x);
    }
}