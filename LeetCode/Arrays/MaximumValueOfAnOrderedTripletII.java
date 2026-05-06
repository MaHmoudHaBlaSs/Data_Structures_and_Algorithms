// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/

class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int maxI = 0;
        int maxDiff = 0;

        for (int x : nums) {
            res = Math.max(res, (long) maxDiff * x);

            
            maxDiff = Math.max(maxDiff, maxI - x);

           
            maxI = Math.max(maxI, x);
        }

        return res;
    }
}