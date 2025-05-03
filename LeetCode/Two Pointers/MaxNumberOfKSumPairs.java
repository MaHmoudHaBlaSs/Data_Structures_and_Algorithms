// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75


class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, res = 0;
        while (left < right) {
            if(nums[left] + nums[right] == k){
                res++;
                left++;
                right--;
            }else if (nums[left] + nums[right]  < k){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}