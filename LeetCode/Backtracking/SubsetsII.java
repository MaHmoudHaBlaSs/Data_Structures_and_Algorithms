// https://leetcode.com/problems/subsets-ii/description/

// Optimal
class Solution {
    List<List<Integer>> subsets = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recurse(nums, 0);
        return subsets;
    }
    public void recurse (int[] nums, int step){
        subsets.add(new LinkedList<>(list));

        for (int i = step; i < nums.length; i++){
            if (i > step && nums[i] == nums[i-1] )
                continue;
            list.add(nums[i]);    
            recurse(nums, i+1);
            list.removeLast();
        }
    }
}
