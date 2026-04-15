/// leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/description/

// Use Sieve theory to compute all primes --> primes checking becomes O(1)  
class Solution {
    public int minOperations(int[] nums) {
        int n = Arrays.stream(nums).max().getAsInt()+71;
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[1] = false;

        for (int i = 2; i*i <= n; i++) {
            if(prime[i]){
                for (int m = i*i; m <= n; m+=i) {
                    prime[m] = false;
                }
            }
        }
        
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; 
            if((i&1) == 0){
                while(!prime[num++]){
                    ans++;
                }
            }else {
                while(prime[num++]){
                    ans++;
                }
            }
        }
        
        return ans; 
    }
}