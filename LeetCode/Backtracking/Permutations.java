// https://leetcode.com/problems/permutations/

class Solution {

    List<List<Integer>> perms = new LinkedList<>(); // O(n)
    List<Integer> temp = new LinkedList<>(); // O(1)
    Set<Integer> set = new HashSet<>(); // O(1)

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return perms;
    }
    public void dfs(int[] nums, int len){
        if (len == nums.length){ // Base Condition
            perms.add(new LinkedList<>(temp));
            return;
        } 
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            temp.add(nums[i]); // Do
            dfs(nums, len+1); // Recurse
            temp.removeLast(); // Undo
            set.remove(nums[i]);
        } 
    }
}
