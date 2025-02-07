// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++)
            set.add(i);
        for (int num: nums)
            set.remove(num);
        return set.stream().toList();
    }
}
