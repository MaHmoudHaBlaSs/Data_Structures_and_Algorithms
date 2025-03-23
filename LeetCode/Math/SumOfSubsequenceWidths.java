///   https://leetcode.com/problems/sum-of-subsequence-widths/


//Consider each element being min and max in some subsequence
//No. of subsequences ending at index i = 2^i
//If the we have sorted array [A, B, C] ==> result = (B-A) + 2*(C-A) + (C-B) = -3A + B - B + 3C

//The answer is that: for each num in nums: 
    //1-Add num to the result nL times, where nL = number of subsequences at which num is the largest number in the subsequence 
    //2-Subtract num from the result nS times, where nS = number of subsequences at which num is the smallest number in the subsequence 


//Tim: O(n)        Space: O(n)
class Solution {
    final int MOD = 1_000_000_007; 
    
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length; 
        long[] pow = new long[n];
        
        pow[0]=1; 
        for(int i=1; i<n; i++) {
            pow[i] = (2 * pow[i-1]) % MOD;
        }

        long ans = 0; 
        for(int i=0;i<n; i++){
            ans -= ( (pow[n-i-1] - 1) * (long)nums[i] ) % MOD; 
            ans = ( ans + ( (pow[i-0] -1) * (long)nums[i] ) % MOD ) % MOD;
        }

        return (int)(ans % MOD);
    }
}