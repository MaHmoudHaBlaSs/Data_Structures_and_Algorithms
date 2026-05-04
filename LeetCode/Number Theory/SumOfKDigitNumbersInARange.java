/// https://leetcode.com/problems/sum-of-k-digit-numbers-in-a-range/description/


//with some analysis, given digits from l to r:
//1- each digit will occur (r-l+1)^k-1 times, in k-1 different positions
//2- the weight of each digit = occurrences * 1 + occurrences * 10 + occurrences * 100 + .... , until 10^(k-1)
//3- each digit will increase the sum by digit * weight

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumOfNumbers(int l, int r, int k) {
        long occurrences = modExp(r-l+1, k-1); 

        long modInverseOf9 = modExp(9, MOD-2); 
        long tenToKMinusOne = (modExp(10, k) - 1 + MOD) % MOD;

        long weight = (tenToKMinusOne*modInverseOf9)%MOD;

        long rangeSum = (((r-l+1)*(l+r))/2) % MOD;
        long sum = (((rangeSum*weight)%MOD) * occurrences)%MOD;

        return (int)sum;
    }

    private long modExp(long base, long exp){
        long ans = 1;

        while (exp > 0){
            if((exp&1) == 1){
                ans = (ans*base) % MOD;
            }
            base = (base*base) % MOD;
            exp >>= 1;
        }

        return ans;
    }
}