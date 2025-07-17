// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/?envType=problem-list-v2&envId=greedy


public class Solution {
    public IList<IList<int>> GroupThePeople(int[] groupSizes)
    {
        IList<IList<int>> result = new List<IList<int>>();
        Dictionary<int, List<int>> groups = new Dictionary<int, List<int>>();

        for (int i = 0; i < groupSizes.Length; i++)
        {
            if (groups.ContainsKey(groupSizes[i]))
            {
                if(groups[groupSizes[i]].Count < groupSizes[i])
                {
                    groups[groupSizes[i]].Add(i);
                }
                else
                {
                    result.Add(groups[groupSizes[i]]);
                    groups[groupSizes[i]] = new List<int> { i };
                }
            }
            else
            {
                groups[groupSizes[i]] = new List<int> { i };
            }
        }
        foreach (var group in groups.Values)
        {
            if (group.Count > 0)
            {
                result.Add(group);
            }
        }

        return result;

    }
}