// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/submissions/1699390181/?envType=study-plan-v2&envId=leetcode-75


public class Solution {
    public int[] SuccessfulPairs(int[] spells, int[] potions, long success)
{
    Array.Sort(potions);
    int[] result = new int[spells.Length];
    for (int i = 0; i < spells.Length; i++)
    {
        int spell = spells[i];
        int count = 0, left = 0 , right = potions.Length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if ((long)spell * potions[mid] >= success)
            {
                count = potions.Length - mid; 
                right = mid - 1; 
            }
            else
            {
                left = mid + 1; 
            }
        }
        result[i] = count;
    }
    return result;

}
}