//  https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    // T: O(n)                  S: O(1) >> return isn't counted.
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        int post = 1;

        // Filling answer with pre-fix values.
        for (int i = 1; i < nums.length; i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
        
        // Overwriting prefixes with final answer after multiplying them by suffixes
        for (int i = answer.length-1; i >= 0; i--){
            post *= (i == answer.length-1)?1:nums[i+1];
            answer[i] = answer[i]*post;
        }
        return answer;
    }
}
