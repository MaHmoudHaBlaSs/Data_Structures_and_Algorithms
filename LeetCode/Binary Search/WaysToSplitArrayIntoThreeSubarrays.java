///  https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/description/

class Solution {
    private static final int MOD = 1_000_000_007;

    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] prefixSum = buildPrefixSum(nums);

        long result = 0;

        // i = end index of left subarray
        for (int i = 1; i < n - 1; i++) {

            int firstMid = findFirstValidMid(prefixSum, i, n - 1);
            if (firstMid == -1) continue;

            int lastMid = findLastValidMid(prefixSum, i, n - 1);
            if (lastMid == -1 || firstMid > lastMid) continue;

            result = (result + (lastMid - firstMid + 1L)) % MOD;
        }

        return (int) result;
    }

    private int[] buildPrefixSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        return prefix;
    }

    private int findFirstValidMid(int[] prefix, int leftEnd, int rightEnd) {
        int leftSum = prefix[leftEnd - 1];
        int low = leftEnd, high = rightEnd - 1;
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midSum = prefix[mid] - leftSum;

            if (midSum >= leftSum) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private int findLastValidMid(int[] prefix, int leftEnd, int rightEnd) {
        int leftSum = prefix[leftEnd - 1];
        int totalSum = prefix[rightEnd];
        int low = leftEnd, high = rightEnd - 1;
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midSum = prefix[mid] - leftSum;
            int rightSum = totalSum - prefix[mid];

            if (midSum <= rightSum) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}