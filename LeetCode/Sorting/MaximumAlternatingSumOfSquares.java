///  https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/

class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0; i<nums.length; ++i)
            nums[i] = Math.abs(nums[i]);
            
        Arrays.sort(nums);

        long ans = 0;
        int l = 0, r = nums.length-1; 
        
        while(l<r){
            ans += nums[r] * nums[r];
            ans -= nums[l] * nums[l]; 

            r--; l++;
        }

        if(l == r) ans += nums[r] * nums[r];

        return ans;
    }
}