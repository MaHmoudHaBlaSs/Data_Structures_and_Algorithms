// https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/

class Solution {
    public int minimumDeletions(int[] nums) {
        int maxIdx = 0 , minIdx = 0 , max = Integer.MIN_VALUE , min = Integer.MAX_VALUE , n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            }
        }
        int left = Math.min(maxIdx,minIdx);
        int right = Math.max(maxIdx,minIdx);

        int deleteFromLeft = right + 1;
        int deleteFromRight = n - left;
        int deleteFromBoth = (left + 1) + (n - right);
        return Math.min(deleteFromLeft, Math.min(deleteFromRight, deleteFromBoth));
    }
}