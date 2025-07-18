///  https://leetcode.com/problems/contains-duplicate-iii/description/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        TreeSet<Integer> tree = new TreeSet<>();

        //we need n1 - n2 <= valueDiff so if we have n1 find n1 - valueDiff <= n2
        for (int i = 0; i < n; i++) {
            if(i > indexDiff)
                tree.remove(nums[i-indexDiff-1]);

            int n1 = nums[i];
            Integer higher = tree.ceiling(n1 - valueDiff);

            if(higher != null && higher <= n1 + valueDiff)
                return true;

            tree.add(n1);
            
            if(i > indexDiff && tree.size() <= indexDiff)
                return true;
        }
        return false;
    }
}