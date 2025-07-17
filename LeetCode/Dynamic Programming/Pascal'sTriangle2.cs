// https://leetcode.com/problems/pascals-triangle-ii/

public class Solution {
    public IList<int> GetRow(int rowIndex)
{
    IList<IList<int>> result = new List<IList<int>>();
    result.Add(new List<int> { 1 });
    for (int i = 1; i <= rowIndex; i++)
    {
        IList<int> row = new List<int>();
        row.Add(1);
        IList<int> prevRow = result[i - 1];
        for (int j = 1; j < i; j++)
        {
            row.Add(prevRow[j - 1] + prevRow[j]);
        }
        row.Add(1);
        result.Add(row);
    }
    return result[rowIndex];
}
}