// https://leetcode.com/problems/combinations/description/


// Optimal.
class Solution {
    List<List<Integer>> combs = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        recurse(n, 0, k);
        return combs;
    }
    public void recurse (int n, int step, int k){
        if (temp.size() == k){
            combs.add(new ArrayList<>(temp));
            return;
        }

        for (int i = step+1; i <= n; i++){
            temp.add(i);
            recurse(n, i, k);
            temp.removeLast();
        }
    }
}