// https://leetcode.com/problems/gcd-of-odd-and-even-sums/description/


class Solution {
    public int gcdOfOddEvenSums(int n) {    
        long oddSum = (long)n * n;           // n²
        long evenSum = (long)n * (n + 1);   

        return gcd((int)oddSum, (int)evenSum);        
    }
    public int gcd (int n , int p ){
        if (p == 0) return Math.abs(n);
        return gcd(p, n % p);
    }
}