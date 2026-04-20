///  https://leetcode.com/problems/direction-assignments-with-exactly-k-visible-people/description/


class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countVisiblePeople(int n, int pos, int k) {
        Combinatorics com = new Combinatorics(n);

        long ans = 0;
        for (int i = 0; i<=k; i++) {
            if(pos >= i && (n-pos-1) >= k-i)
                ans = (ans + (com.nCr(pos, i) * 2 * com.nCr(n-pos-1, k-i)) % MOD) % MOD;
        }
        
        return (int)ans;
    }

    static class Combinatorics{
        private int maxN;
        private long[] fact, invFact;
        private static final long MOD = 1_000_000_007L;

        public Combinatorics(int maxN) {
            this.maxN = maxN;;
            fact = new long[maxN+1];
            invFact = new long[maxN+1];

            fact[0] = 1;
            for (int i = 0; i < maxN; i++) {
                fact[i+1] = (fact[i] * (i+1)) % MOD;
            }

            invFact[maxN] = power(fact[maxN], MOD - 2);
            for (int i = maxN; i > 0; i--) {
                invFact[i-1] = (invFact[i] * i) % MOD;
            }
        }

        public long nCr(int n, int r) {
            if (r < 0 || r > n) return 0;
            return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
        }

        private long power(long base, long exp) {
            long res = 1;
            base %= MOD;
            while (exp > 0) {
                if (exp % 2 == 1) res = (res * base) % MOD;
                base = (base * base) % MOD;
                exp /= 2;
            }
            return res;
        }
    }
}