/// https://leetcode.com/problems/longest-happy-prefix/description/

class Solution {
    private static final long MOD = 1_000_000_007L, BASE = 31;

    private long modInverse(long n){
        return powerExp(n, MOD-2);
    }
    private long powerExp(long base, long exp){
        long result = 1;

        while(exp>0){
            if((exp&1)==1){
                result = (result * base) % MOD;
            }
            exp >>= 1;
            base = (base * base) % MOD;
        }

        return result;
    }
    private void constructPowers(long[] pow, long[] invPow){
        int n = pow.length;
        pow[0] = 1;
        for(int i=1;i<n;i++){
            pow[i] = (pow[i-1] * BASE) % MOD;
        }

        invPow[n-1] = modInverse(pow[n-1]);
        for(int i=n-2;i>=0;i--){
            invPow[i] = (invPow[i+1] * BASE) % MOD;
        }
    }


    public String longestPrefix(String s) {
        int n = s.length();
        long[] pow =  new long[n+1], invPow =  new long[n+1], prefix = new long[n+1];

        constructPowers(pow, invPow);

        for(int i=0;i<n;i++){
            int val = s.charAt(i)-'a'+1;
            prefix[i+1] = prefix[i] + val * pow[i];
        }

        int ans = -1;
        for(int i=0;i<n-1;i++){
            long l = (prefix[i+1] * invPow[0]) % MOD;
            
            long r = (prefix[n] - prefix[n-i-1] + MOD) % MOD;
            r = (r * invPow[n-i-1]) % MOD;
            
            if(l == r) ans = i;
        }

        return s.substring(0,ans+1);
    }
}
