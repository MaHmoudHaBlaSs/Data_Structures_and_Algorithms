///  https://leetcode.com/problems/maximize-total-cost-of-alternating-subarrays/description/

/* 
For each element nums[i] there is 2 options: 
    1-start a new subarray from here --> Take the best answer until (i-1) then add nums[i] to it.
    2-complete the previous subarray --> Add nums[i] to the best answer until (i-1) if nums[i-1] was taken by - 
    or subtract nums[i] from the best answer until (i-1) if nums[i-1] was taken by +   
*/

class Solution {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        //Answer in case the last element is taken by + or - 
        long lastFlipped = Long.MIN_VALUE, lastNotFlipped = nums[0];  

        for (int i = 1; i < n; i++) {
            long newLF = lastNotFlipped - nums[i];
            long newLNF = Math.max(lastNotFlipped, lastFlipped) + nums[i];

            lastFlipped = newLF;
            lastNotFlipped = newLNF;
        }

        return Math.max(lastNotFlipped, lastFlipped);
    }
}
