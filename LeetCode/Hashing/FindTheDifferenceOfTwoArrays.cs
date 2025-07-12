// https://leetcode.com/problems/find-the-difference-of-two-arrays/submissions/1695339960/?envType=study-plan-v2&envId=leetcode-75


public class Solution {
    public IList<IList<int>> FindDifference(int[] nums1, int[] nums2)
{
    IList<IList<int>> res ;
    res = new List<IList<int>>();
    HashSet<int> set1 = new HashSet<int>(nums1);
    HashSet<int> set2 = new HashSet<int>(nums2);
    IList<int> list1 = new List<int>();
    IList<int> list2 = new List<int>();
    foreach (var item in set1)
    {
        if (!set2.Contains(item))
        {
            list1.Add(item);
        }
    }
    foreach (var item in set2)
    {
        if (!set1.Contains(item))
        {
            list2.Add(item);
        }
    }
    res.Add(list1);
    res.Add(list2);



    return res;
}
}