// https://leetcode.com/problems/subsets/description/

// T: O(n* 2^n)      S: O(n)
class Solution {
    List<List<Integer>> groups = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return groups;
    }
    
    public void dfs(int[] nums, int i){
        if (i == nums.length){
            groups.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(nums, i+1);
        temp.removeLast();
        dfs(nums, i+1);
    }
}
