///  https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/description/


class Solution {
    public int longestSubsequence(int[] nums) {
        int zeros = 0, mask = 0, n = nums.length;

        for(int num : nums){
            if(num == 0) zeros++;

            mask ^= num;
        }

        if(zeros == n) return 0;

        return mask == 0 ? n-1 : n;
    }
}