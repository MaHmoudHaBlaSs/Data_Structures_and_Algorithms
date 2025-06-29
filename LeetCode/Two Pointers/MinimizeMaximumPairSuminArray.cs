///  https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/


public class Solution {
    public int MinPairSum(int[] nums) {
        Array.Sort(nums);
        int left = 0, right = nums.Length-1, ans = 0;

        while(left < right)
            ans = Math.Max(ans, nums[left++] + nums[right--]);

        return ans;    
    }
}