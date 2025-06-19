// https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/?envType=daily-question&envId=2025-06-19

class Solution {
    public int partitionArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        int count = 0 , l = 0, r = 0 ;
        while (l < nums.length ) {
            while(r < nums.length && nums[r] - nums[l] <= k ) {
                r++;
            }
            count++;
            l = r;
        }
        return count;

    }
}