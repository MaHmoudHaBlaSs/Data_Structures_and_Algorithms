/// https://leetcode.com/problems/maximize-number-of-nice-divisors/description/


class Solution {
    public int maxNiceDivisors(int primeFactors) {
        if(primeFactors <= 4) return primeFactors;
        
        int ans = 1;
        
        if(primeFactors % 3 == 0) 
            ans = pow(3, primeFactors / 3);
        if(((primeFactors-2) % 3) == 0) 
            ans = Math.max(ans,(int)((2L * pow(3, (primeFactors-2) / 3)) % 1_000_000_007L));
        
        if(((primeFactors-4) % 3) == 0)
            ans = Math.max(ans, (int)((4L * pow(3, (primeFactors-4) / 3)) % 1_000_000_007L));

        return ans;
    }

    private int pow(long base, long power){
        if(power == 0) return 1;
        if(power == 1) return (int)base;

        long num = pow(base, power / 2);
        num = (num * num) % 1_000_000_007L;

        return (int)((power & 1) == 0 ? num : (num * base) % 1_000_000_007L);
    }
}