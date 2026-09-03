// https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/description/


class Solution {
    public boolean checkDivisibility(int n) {
        int num = n , sum = 0 ,prod = 1 ;
        while( num > 0 ){
            int digit = num % 10;
            sum += digit;
            prod *= digit;
            num /= 10;
        }
        return (n % (sum+prod)) == 0;
    }
}