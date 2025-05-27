///   https://leetcode.com/problems/arithmetic-slices/description/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, n = nums.length;

        for(int left = 0; left<n-2; left++){
            int right = left+1, diff = nums[right]- nums[left];
            
            while(right+1 < n && nums[right+1]-nums[right] == diff) 
                right++;

            int size = right - left - 1;
            if(size > 0) 
                ans +=  size * (size+1)/  2;
                
            left = right-1;
        }

        return ans;
    }
}