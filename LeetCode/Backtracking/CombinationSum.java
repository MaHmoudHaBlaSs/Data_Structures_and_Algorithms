// https://leetcode.com/problems/combination-sum/description/

// Beats 5% Need to be optimized.
class Solution {
    Set<List<Integer>> combs = new HashSet<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new LinkedList<>(), 0);
        return combs.stream().toList();
    }

    public void dfs (int[] candidates, int target, List<Integer> list, int sum){
        for (int i = 0; i < candidates.length; i++){
            list.add(candidates[i]);
            Collections.sort(list);
            if (sum+candidates[i] == target)
                combs.add(new LinkedList<>(list));
            else if (sum+candidates[i] < target)
                dfs(candidates, target, new LinkedList<>(list),sum+candidates[i]);
            list.remove(Integer.valueOf(candidates[i]));
        }
    }
}
