--> https://leetcode.com/problems/valid-parentheses/description/


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !checkPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean checkPair(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
               (c1 == '{' && c2 == '}') ||
               (c1 == '[' && c2 == ']');
    }
}