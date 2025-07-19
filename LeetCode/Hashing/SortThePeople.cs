// https://leetcode.com/problems/sort-the-people/description/?envType=problem-list-v2&envId=hash-table


public class Solution {
    public string[] SortPeople(string[] names, int[] heights)
    {
        SortedList<int, List<string>> dict = new SortedList<int, List<string>>();

        for (int i = 0; i < names.Length; i++)
        {
            if (!dict.ContainsKey(heights[i]))
            {
                dict[heights[i]] = new List<string>();
            }
            dict[heights[i]].Add(names[i]);
        }

        string[] sortedNames = new string[names.Length];
        int index = 0;

        for (int i = dict.Count - 1; i >= 0; i--)
        {
            int height = dict.Keys[i];
            List<string> namesAtHeight = dict.Values[i];

            foreach (var name in namesAtHeight)
            {
                sortedNames[index++] = name;
            }
        }

        return sortedNames;
    }
}