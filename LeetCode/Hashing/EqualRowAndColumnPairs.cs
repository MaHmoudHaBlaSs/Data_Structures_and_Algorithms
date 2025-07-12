// https://leetcode.com/problems/equal-row-and-column-pairs/description/


public class Solution {
    public int EqualPairs(int[][] grid)
    {
        // <row , if dublicated increase it is count>
        Dictionary<string,int> rows = new Dictionary<string, int>();

        
        foreach (var row in grid)
        {
            if (rows.ContainsKey(string.Join(",", row)))
            {
                rows[string.Join(",", row)]++;
            }
            else
            {
                rows[string.Join(",", row)] = 1;
            }
        }

        int count = 0;

        
        for (int j = 0; j < grid[0].Length; j++)
        {
            List<int> column = new List<int>();
            for (int i = 0; i < grid.Length; i++)
            {
                column.Add(grid[i][j]);
            }

            
            if (rows.ContainsKey(string.Join(",", column)))
            {
                count+= rows[string.Join(",", column)];
            }
        }

        return count;
    }
}