///  https://leetcode.com/problems/minimum-xor-sum-of-two-arrays/description/

public class Solution {
    private int[] nums1, nums2;
    private Dictionary<(int index, int mask), int> memo = new Dictionary<(int , int), int>();

    private int Solve(int index, int mask)
    {
        if (index == nums1.Length) return 0;

        var key = (index, mask);
        if (memo.ContainsKey(key)) return memo[key]; 

        int ans = int.MaxValue;
        for (int i = 0; i < nums1.Length; i++)
        {
            if ((mask & (1 << i)) == 0)
            {
                ans = Math.Min(ans, (nums1[index] ^ nums2[i]) + Solve(index + 1, mask | (1 << i)));
            }
        }

        return memo[key] = ans;
    }

    public int MinimumXORSum(int[] nums1, int[] nums2)
    {
        this.nums1 = nums1;
        this.nums2 = nums2;
        return Solve(0, 0);
    }
}