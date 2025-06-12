// https://leetcode.com/problems/combination-sum-ii

class Solution {
    List<List<Integer>> combs = new LinkedList<>();
    List<Integer> comb = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        recurse(0, 0, 0, k, n);
        return combs;
    }
    public void recurse(int i, int step, int currSum, int k, int n){
        if (step > k || currSum > n)
            return;
        
        if (currSum == n && step == k){
            combs.add(new ArrayList<>(comb));
            return;
        }
        
        for (int num = i+1; num <= 9; num++){
            comb.add(num);
            recurse(num, step+1, currSum + num, k, n);
            comb.removeLast();
        }
    }
}