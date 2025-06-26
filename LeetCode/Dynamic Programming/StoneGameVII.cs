/// https://leetcode.com/problems/stone-game-vii/description/

/*
Recursive relation: 
    -solve(i,j) is the solution for the problem for subarray from i to j.
    -solve(i,j) =  0 if i == j
                or max { sum of subarray (i,j-1) - solve(i,j-1), sum of subarray (i+1,j) - solve(i+1,j) } 
*/

//Time: O(n^2)   Space: O(n^2)
public class Solution {
    public int StoneGameVII(int[] stones)
    {
        int n = stones.Length;
        int[,] dp = new int[n,n];

        for (int i = 1; i < n; i++)
            stones[i] = stones[i - 1] + stones[i];
        
        for (int i=n-1; i >= 0; i--)
        {
            for (int j = i+1; j < n; j++)
            {
                int op1 = stones[j-1] - (i > 0 ? stones[i - 1] : 0) - dp[i, j - 1];
                int op2 = stones[j] - stones[i] - dp[i + 1, j];
                dp[i, j] = Math.Max(op1, op2);
            }
        }

        return dp[0,n-1];
    }
}