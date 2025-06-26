///  https://leetcode.com/problems/stone-game-vi/description/

public class Solution {
    public int StoneGameVI(int[] aliceValues, int[] bobValues)
    {
        int[][] arr = new int[aliceValues.Length][];

        for(int i = 0; i < aliceValues.Length; i++)
            arr[i] = new int[] { aliceValues[i], bobValues[i]};
        
        Array.Sort(arr, (a, b) => (b[0] + b[1]).CompareTo(a[0] + a[1]));
        bool aliceTurn = true;
        int aliceScore = 0, bobScore = 0;

        foreach (int[] item in arr)
        {
            if (aliceTurn) aliceScore += item[0];
            else bobScore += item[1];

            aliceTurn = !aliceTurn;
        }

        return aliceScore == bobScore ? 0 : (aliceScore > bobScore ? 1 : -1);
    }
}