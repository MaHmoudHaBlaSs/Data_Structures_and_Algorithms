// https://leetcode.com/problems/number-of-good-pairs/description/?envType=problem-list-v2&envId=hash-table


public class Solution {
    public int NumIdenticalPairs(int[] nums)
    {
        int[] freq = new int[102];
        foreach (var num in nums)
        {
            freq[num]++;
        }
        int count = 0;
        foreach (var f in freq)
        {
            if (f > 1)
            {
                count += (f * (f - 1)) / 2; // التوافيق (:
            }
        }
        return count;

    }
}