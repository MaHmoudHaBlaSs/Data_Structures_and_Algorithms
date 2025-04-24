// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/?envType=problem-list-v2&envId=greedy


// O( N )
class Solution {
    public int minSwaps(String s) {
        int unbalanced = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else { 
                if (!stack.isEmpty()) {
                    stack.pop(); 
                } else {
                    unbalanced++; 
                }
            }
        }

        return (unbalanced + 1) / 2;
    }
}
