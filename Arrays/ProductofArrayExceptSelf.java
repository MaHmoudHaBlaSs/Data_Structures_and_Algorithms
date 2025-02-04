//  https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length]; pre[0] = 1;
        int[] answer = new int[nums.length];
        int post = 1;
        for (int i = 1; i < nums.length; i++)
            pre[i] = pre[i-1]*nums[i-1];
        for (int j = nums.length-1; j >= 0; j--){
            answer[j] = post*pre[j];
            post *= nums[j];
        }
        return answer;
    }
}
