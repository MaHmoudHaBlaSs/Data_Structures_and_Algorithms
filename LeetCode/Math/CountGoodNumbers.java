///  https://leetcode.com/problems/count-good-numbers/description/

class Solution { 
    private final int MOD = 1_000_000_007; 
    
    private long pow(int base, long power){
        if(power == 0) return 1;

        long p = pow(base, power/2);
        if((power & 1) == 0)
            return (p*p) % MOD;
            
        return ((p*p) % MOD )* base % MOD;
    }

    public int countGoodNumbers(long n) {
        long oddIndices = n/2; 
        return (int)((pow(4, oddIndices) * pow(5, n-oddIndices)) % MOD);
    }
}