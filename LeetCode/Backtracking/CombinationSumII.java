// https://leetcode.com/problems/combination-sum-ii/description/
 
// T: O(n * n^2)         S: O(n)
class Solution {
    // S: O(n)
    List<List<Integer>> combs = new LinkedList<>();
    List<Integer> temp = new LinkedList<>(); // O(1)

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target);
        return combs;
    }
  
    // T: O(n * n^2)          S: O(1)
    public void dfs(int[] candidates, int i, int sum, int target){
        if (sum == target){
            combs.add(new ArrayList<>(temp));
            return; // any futher recurse (addition) will result a sum larger than target
        }
        if (sum > target ||i == candidates.length) 
            return; // any futher recurse (addition) will result a sum larger than target
            
        temp.add(candidates[i]);
        dfs(candidates, i+1, sum + candidates[i], target); // Recurse Left
        temp.removeLast(); // Undo

        while (i+1 < candidates.length && candidates[i] == candidates[i+1]) // Skip Duplicates (already calculated, so we skip them)
            i++;
        dfs(candidates, i+1, sum, target); // Recurse Right
    }
}
