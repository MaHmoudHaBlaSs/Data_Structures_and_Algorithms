///  https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/description/


class Solution {
    private static final int oo = 0x3f3f3f3f;

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, r=n-1, sum = 0;

        int[] minLen = new int[n];
        Arrays.fill(minLen, oo);

        for (int l = n-1; l >= 0; --l) {
            sum += arr[l];
            while(r > l && sum > target) sum -= arr[r--];

            int prev = l+1 < n ? minLen[l+1] : oo;
            
            if (sum == target) minLen[l] = Math.min(r-l+1, prev);
            else minLen[l] = prev;
        }

        int ans = oo, l=0;  sum = 0;
        for(r=0; r<n-1; ++r) {
            sum  += arr[r];
            while(r > l && sum > target) sum -= arr[l++];

            if (sum == target) ans = Math.min(ans, minLen[r+1] + r-l+1);
        }

        return ans == oo ? -1 : ans;
    }
}