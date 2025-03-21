///      https://leetcode.com/problems/nth-magical-number/


//Number of numbers between a : K and divisible by a is k/a 
//Number of numbers between b : K and divisible by b is k/b 
//Number of numbers between max(a,b) : K and divisible by both a,b is k/lcm(a,b) 

//Time: O(log(n * min(b,a)))             Space: O(1) 
class Solution {
    public int nthMagicalNumber(int n, long a, long b) {
        long ans= 0, left = 2, right;

        if(a < b) right = n * a;
        else right = n * b;

        ans = right;
        long lcm = a*(b/ gcd(a,b));

        while(left <= right){
            long mid = (left + right) / 2L;
            
            long rank = (mid / a) + (mid/ b) - (mid/ lcm); 
            if(rank >= n) {
                ans = mid;
                right = mid-1;
            } 
            else left = mid+1;
        }

        return (int)(ans % 1_000_000_007);
    }

    private long gcd(long a, long b) {  // O(log(n))
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}