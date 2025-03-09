// https://leetcode.com/problems/generate-parentheses/description/
// Try to solve it using Stack !!

// Optimal Solution.
class Solution {
    StringBuilder comb = new StringBuilder(); // S: O(n)
    List<String> combs = new LinkedList<>(); // S: O(1) >> Placeholder

    public List<String> generateParenthesis(int n) {
        recurse (n, 0, 0);
        return combs;
    }

    // Time and Space Complexities are difficult to compute but they are pretty high
    public void recurse(int n, int opened, int closed){
        if (closed == n && opened == n) {
            combs.add(new String(comb.toString()));
            return;
        }

        if (opened < n){ // False only when opened == n
            comb.append('(');
            recurse(n, opened+1, closed);
            comb.setLength(comb.length()-1);
        }
        if (opened > closed){
            comb.append(')');
            recurse(n, opened, closed+1);
            comb.setLength(comb.length()-1);
        }
    }
}
