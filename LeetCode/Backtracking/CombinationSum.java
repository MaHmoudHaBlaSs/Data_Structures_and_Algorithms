// https://leetcode.com/problems/combination-sum/description/

// Optimal Backtracking Solution.
class Solution {

    List<List<Integer>> combs = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recurse(candidates, 0, target, 0);
        return combs;
    }
    // stemp parameter is used to avoid duplicate decisions again.
    public void recurse(int[] candidates, int sum, int target, int step){
        if (sum >= target){
            if (sum == target)
                combs.add(new LinkedList<>(list)); 
            return;
        }
        
        for (int i = step; i < candidates.length; i++){
            list.add(candidates[i]);
            recurse(candidates, sum+candidates[i], target, i);
            list.removeLast();
        }
    }
}
