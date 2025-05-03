// https://leetcode.com/problems/array-partition/

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxPairsSum = 0;
    // we can observe that even numbers in sorted array  are the min in their pairs
        for (int i = 0; i < nums.length; i+=2){
            if (i%2 == 0) 
                maxPairsSum += nums[i];
        }
        return maxPairsSum;
    }
}