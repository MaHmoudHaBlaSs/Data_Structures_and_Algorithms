// https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/

class Solution {
     public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;  // Extract last digit
                num /= 10;         // Remove last digit
            }
            min = min > sum ? sum : min ;
        }
        return min;
    }
}