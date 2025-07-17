// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75


public class Solution {
    public int LongestSubarray(int[] nums)
    {
        int maxLength = 0, zeroCounter = 0, left = 0, right = 0;

        while (right < nums.Length)
        {
            if (nums[right] == 1)
            {
                right++;
            }
            else
            {
                zeroCounter++;
                right++;

            
                while (zeroCounter > 1)
                {
                    if (nums[left] == 0)
                    {
                        zeroCounter--;
                    }
                    left++;
                }
            }
            maxLength = Math.Max(maxLength, right - left - 1);
        }
        return maxLength;
    }
}