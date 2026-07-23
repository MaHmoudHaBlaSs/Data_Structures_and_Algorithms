// https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/


class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0],nums[nums.length-1]);
    }
    public int gcd(int n , int p){
        if(p == 0 ) return n ;
        return gcd(p, n % p );
    }
}