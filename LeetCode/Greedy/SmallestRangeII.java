/// https://leetcode.com/problems/smallest-range-ii/


//The greedy solution is to increase all small numbers and decrease all large numbers, so just sort it
//For index i: smallerNums = nums[0...i] , largerNums = nums[i+1...n] 
//If you have decreased largeNums and increased smallerNums, there two options for min and max 
    //1- min = nums[0] or nums[i+1]
    //2- max = nums[n] or nums[i]


class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        
        int n = nums.length; 
        int ans = nums[n-1] - nums[0]; 
        
        nums[n-1] -= k;

        for(int i=n-2; i>=0; i--){
            int min = Math.min(nums[0]+k, nums[i+1]); 
            int max = Math.max(nums[n-1], nums[i]+k); 

            ans = Math.min(ans, max - min); 
            nums[i] -= k;
        }

        return ans;
    }
}