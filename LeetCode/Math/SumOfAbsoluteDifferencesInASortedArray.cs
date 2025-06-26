///   https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/

public class Solution {
    public int[] GetSumAbsoluteDifferences(int[] nums)
    {
        int sum = nums.Sum(), prevSum = 0, n = nums.Length;
        int[] result = new int[n];

        for(int i=0; i<n; i++)
        {
            sum -= nums[i];
            result[i] = nums[i] * i - prevSum + sum - nums[i] * (n - i - 1);
            prevSum += nums[i];
        }

        return result;
    }
}