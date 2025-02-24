// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

class Solution {
    // T: O(n)       S: O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++)
            set.add(i);
        for (int num: nums)
            set.remove(num);
        return set.stream().toList();
    }

    // T: O(n)       S: O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length];
        List<Integer> list = new LinkedList<>();

        for (int num: nums)
            arr[num-1] = 1;
        for (int i = 0; i < nums.length; i++)
            if (arr[i] == 0) list.add(i+1);
        return list;
    }
}
