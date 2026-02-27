///  https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] all = new int[n*(n+1)/2];
        int k=0;
        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j=i; j<n; j++) {
                sum+=nums[j];
                all[k++]=sum;
            }
        }
        
        Arrays.sort(all);
        long ans=0;
        for (int i = left-1; i < right; i++) {
            ans = (ans + all[i]) % MOD;
        }
        
        return (int)ans;
    }
}