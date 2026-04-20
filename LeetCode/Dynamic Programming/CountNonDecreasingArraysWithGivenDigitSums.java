///  https://leetcode.com/problems/count-non-decreasing-arrays-with-given-digit-sums/description/


class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_VAL = 5000;

    public int countArrays(int[] digitSum) {
        int n = digitSum.length;
        List<Integer>[] lists = new List[51];
        
        for (int i = 0; i <= 50; i++) lists[i] = new ArrayList<>();

        for (int v = 0; v <= MAX_VAL; v++) {
            int sum = 0, temp = v;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum <= 50) lists[sum].add(v);
        }

        // ways[v] = number of valid sequences from index i to n-1 
        // given that the value at index i-1 was v.
        int[] ways = new int[MAX_VAL + 1];

        for (int v : lists[digitSum[n - 1]]) {
            ways[v] = 1; 
        }

        for (int i = n - 2; i >= 0; i--) {
            int currentTargetSum = digitSum[i];
            int[] nextWays = new int[MAX_VAL + 1];
            
            int[] suffixSum = new int[MAX_VAL + 2];
            for (int v = MAX_VAL; v >= 0; v--) {
                suffixSum[v] = (suffixSum[v + 1] + ways[v]) % MOD;
            }

            // For each valid number v for the current digitSum[i]
            // its contribution is the sum of all valid paths starting with nextVal >= v
            for (int v : lists[currentTargetSum]) {
                nextWays[v] = suffixSum[v];
            }
            
            ways = nextWays;
        }

        long total = 0;
        for (int v : lists[digitSum[0]]) {
            total = (total + ways[v]) % MOD;
        }

        return (int) total;
    }
}