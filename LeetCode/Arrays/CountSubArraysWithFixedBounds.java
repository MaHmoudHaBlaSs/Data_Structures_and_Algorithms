///   https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/

/*
keeping track of:
    The most recent index where nums[i] < minK or nums[i] > maxK
    The most recent index where nums[i] == minK
    The most recent index where nums[i] == maxK

For each position, we can count how many valid subarrays end at the current position from these tracked indices.
*/

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int boundaryViolationPos = -1, lastMinKPos = -1, lastMaxKPos = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) 
                boundaryViolationPos = i;
            
            if (nums[i] == minK) lastMinKPos = i;
            if (nums[i] == maxK) lastMaxKPos = i;
            

            if (lastMinKPos > boundaryViolationPos && lastMaxKPos > boundaryViolationPos) {
                long validStartPositions = Math.min(lastMinKPos, lastMaxKPos) - boundaryViolationPos;
                result += validStartPositions;
            }
        }
        
        return result;
    }
}