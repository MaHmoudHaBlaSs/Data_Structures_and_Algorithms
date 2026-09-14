///  https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/description/

class Solution {
    public int smallestValue(int n) {
        int sum=n;
        
        do {
            n = sum;
            sum = sumOfPrimeFactors(n);
        }while(n != sum);
        
        return n;
    }

    private int sumOfPrimeFactors(int n){
        int sum = 0;

        for(int i=2; i*i<= n; ++i){
            while(n%i == 0){
                n /= i;
                sum += i;
            }
        }

        if(n != 1) sum += n;

        return sum;
    }
}