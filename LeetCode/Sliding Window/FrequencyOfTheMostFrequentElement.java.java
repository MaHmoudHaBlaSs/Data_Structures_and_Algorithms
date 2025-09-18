/// https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

class Solution {
    public int maxFrequency(int[] nums, long k) {
        Arrays.sort(nums); 
        int n = nums.length; 
        int ans = 1, left=0;
        long sum = 0;

        for(int right=0; right<n; right++){
            sum += nums[right];

            long len = right-left+1;
            while(nums[right] * len - sum > k){
                sum -= nums[left++];
                len--; 
            }

            ans  = (int)Math.max(ans, len);
        }

        return ans; 
    }
}