///  https://leetcode.com/problems/largest-prime-from-consecutive-prime-sum/description/

class Solution {
    public int largestPrime(int n) {
        if(n==1) return 0;

        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true); 
    
        for(int i=2; i<=n; ++i){
            if(prime[i]){
                for(int j=i*2; j<=n; j+=i){
                    prime[j] = false;
                }
            }
        }

        int sum = 0, ans = 0;
        for(int i=2; i<=n; ++i){
            if(prime[i]){
                if(sum + i <= n) sum += i;
                else return ans;

                if(prime[sum]) ans = sum; 
            }
        }

        return ans; 
    }
}