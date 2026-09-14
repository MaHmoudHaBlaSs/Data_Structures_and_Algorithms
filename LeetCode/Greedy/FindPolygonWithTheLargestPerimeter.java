///  https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description/

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long ans = -1, sum = nums[0] + nums[1];

        for(int i=2; i<nums.length; ++i){
            if(nums[i] < sum){
                ans = sum + nums[i];
            }

            sum += nums[i];
        }

        return ans;
    }
}