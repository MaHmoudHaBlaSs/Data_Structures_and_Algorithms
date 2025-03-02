// https://leetcode.com/problems/subsets/description/

class Solution {
    List<List<Integer>> groups = new ArrayList<>();
    
    // T: O(n* 2^n)      S: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return groups;
    }

    public void dfs(int[] nums, ArrayList list, int i){
        if (i == nums.length){
            groups.add(list.stream().toList());
            return;
        }    
        list.add(nums[i]);
        dfs(nums, list, i+1);

        list.remove(Integer.valueOf(nums[i]));
        dfs(nums, list, i+1);
    }
}
