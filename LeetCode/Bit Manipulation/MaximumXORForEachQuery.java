///  https://leetcode.com/problems/maximum-xor-for-each-query/description/


class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length, mask = 0, max = (1<<maximumBit)-1;
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            mask ^= nums[i]; 
            answer[n-i-1] = mask ^ max;
        } 

        return answer; 
    }
}