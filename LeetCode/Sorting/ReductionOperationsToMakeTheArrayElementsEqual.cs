///  https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/description/

public class Solution {
    public int ReductionOperations(int[] nums) {
        Array.sort(nums);
        int ans = 0, n = nums.Length; 

        for(int i=1; i<n; i++)
        {
            if(nums[n-i-1] != nums[n-i]) 
                ans += i;
        }

        return ans; 
    }
}