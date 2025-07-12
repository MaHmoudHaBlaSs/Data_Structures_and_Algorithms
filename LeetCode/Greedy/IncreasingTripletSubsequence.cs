// https://leetcode.com/problems/increasing-triplet-subsequence/


public class Solution {
    public bool IncreasingTriplet(int[] nums)
    {
        if (nums == null || nums.Length < 3)
        {
            return false;
        }
        int first = int.MaxValue;
        int second = int.MaxValue;
        foreach (int num in nums)
        {
            if (num <= first)
            {
                first = num; 
            }
            else if (num <= second)
            {
                second = num; 
            }
            else
            {
                
                return true;
            }
        }
        return false;
    }
}