// https://leetcode.com/problems/generate-parentheses/description/
// Try to solve it using Stack like Neetcode !!

class Solution {
    List<String> sets = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        permutations(new StringBuilder(), 0, 0, n);
        return sets;
    }
    public void permutations(StringBuilder set, int opened, int closed, int total){
        if (opened == total && closed == total){
            sets.add(set.toString());
            return;
        }
        if (closed > opened) return;
        if (opened < total && closed < total){
            permutations(new StringBuilder(set.append('(')), opened+1, closed, total);
            set.setLength(set.length()-1);
            permutations(new StringBuilder(set.append(')')), opened, closed+1, total);
        }
        else if (opened == total)
            permutations(new StringBuilder(set.append(')')), opened, closed+1, total);

    }
}
