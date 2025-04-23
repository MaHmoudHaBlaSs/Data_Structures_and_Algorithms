// https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/?envType=problem-list-v2&envId=greedy


class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            ans[i] = longestSubsequence(nums, queries[i]);
        }

        return ans;
    }

    public static int longestSubsequence(int[] arr, int limit) {
        int sum = 0, count = 0;

        for (int num : arr) {
            if (sum + num <= limit) {
                sum += num;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
