// https://leetcode.com/problems/valid-triangle-number

// T: O(n^2)              S: O(1)
class Solution {
    public int triangleNumber(int[] nums) {
        int triangles = 0;
        Arrays.sort(nums);

        // We are fixing the greatest side and try to find out which two from other sides fits.
        // If you start it from i = 0 to i = len-1 it won't work 😑
        for (int i = nums.length-1; i > 0; i--){
            int left = 0, right = i-1;
            
            while (left < right){
                if (nums[left] + nums[right] <= nums[i]) 
                    left++;
                else{
                    triangles += right - left; // Brainstorm it
                    right--;
                }
            }
        }
        return triangles;
    }
}