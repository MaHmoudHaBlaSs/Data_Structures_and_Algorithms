///  https://leetcode.com/problems/super-ugly-number/description/

/*
ugly[i] holds the i-th super ugly number.
For each prime p, you want to find the smallest multiple of p that is greater than all previously generated ugly numbers.
nextUgly[j] tells you which index of the ugly array to multiply by primes[j] to get the next candidate number
*/

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) { 
        long[] ugly = new long[n];
        int[] nextUgly = new int[primes.length];
        ugly[0] = 1;

        for(int i=1; i<n; i++){
            long u = primes[0] * ugly[nextUgly[0]];

            for(int j=1; j<primes.length; j++){
                if(primes[j] * ugly[nextUgly[j]] < u) 
                    u = primes[j] * ugly[nextUgly[j]];
            }            
            
            for(int j=0; j<primes.length; j++){
                if(primes[j] * ugly[nextUgly[j]] == u)
                    nextUgly[j]++;
            }

            ugly[i] = u;
        }

        return (int)ugly[n-1];
    }

}