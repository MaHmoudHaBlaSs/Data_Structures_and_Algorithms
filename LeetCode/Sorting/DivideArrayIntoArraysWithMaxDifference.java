///  https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length/3][3];
        int j = 0;

        for(int i=2; i<nums.length; i += 3){
            if(nums[i] - nums[i-2] <= k){
                ans[j++] = new int[]{nums[i], nums[i-1], nums[i-2]};
            }else{
                return new int[0][0];
            }
        }

        return ans;
    }
}