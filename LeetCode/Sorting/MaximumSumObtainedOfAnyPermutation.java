///  https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/description/

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] arr = new int[n+1];

        for(int[] request: requests){
            arr[request[0]]++;
            arr[request[1]+1]--;
        }

        for(int i=0; i<n; ++i) arr[i+1] += arr[i];

        Arrays.sort(arr);
        Arrays.sort(nums);

        long ans = 0;
        for (int i=0; i<n; ++i){
            ans = (ans+ ((long) nums[i] *arr[i+1])%MOD) % MOD;
        }

        return (int)ans;
    }
}