///  https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k/description/

class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        long ans = 0;

        if(nums[mid] < k){
            for(int i=mid; i<nums.length; ++i){
                if(nums[i] < k){
                    ans += k - nums[i];
                }else{
                    break;
                }
            }
        }else{
            for(int i=mid; i>=0; --i){
                if(nums[i] > k){
                    ans += nums[i] - k;
                }else{
                    break;
                }
            }            
        }

        return ans;
    }
}