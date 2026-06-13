// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/


class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, mid, threshold)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        return left;
    }
    public boolean canDivide(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceilDiv(num, divisor); 
        }
        return sum <= threshold;
    }
}