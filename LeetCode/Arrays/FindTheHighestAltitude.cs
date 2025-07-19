// https://leetcode.com/problems/find-the-highest-altitude/description/


public class Solution {
    public int LargestAltitude(int[] gain)
    {
        int maxAltitude = 0 ;
        int[] gains = new int[gain.Length + 1];
        gains[0] = 0;
        for (int i = 0; i < gain.Length; i++)
        {
            gains[i + 1] = gains[i] + gain[i];

            maxAltitude = gains[i + 1] > maxAltitude ? gains[i + 1] : maxAltitude;
        }
        return maxAltitude;
    }
}