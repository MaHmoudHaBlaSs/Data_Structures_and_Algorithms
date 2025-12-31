/// https://leetcode.com/problems/maximum-score-from-removing-substrings/description/

class Solution {
    public int maximumGain(String s, int x, int y) {
        char first, second;
        int gainFirst, gainSecond;

        if (x >= y) {
            first = 'a'; second = 'b';
            gainFirst = x; gainSecond = y;
        } else {
            first = 'b'; second = 'a';
            gainFirst = y; gainSecond = x;
        }

        Stack<Character> stack = new Stack<>();
        int score = 0;

        for (char c : s.toCharArray()) {
            if (c != 'a' && c != 'b') {
                score += flush(stack, gainSecond);
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                score += gainFirst;
            } else {
                stack.push(c);
            }
        }

        score += flush(stack, gainSecond);
        return score;
    }

    private int flush(Stack<Character> stack, int gain) {
        int countA = 0, countB = 0;

        while (!stack.isEmpty()) {
            if (stack.pop() == 'a') countA++;
            else countB++;
        }

        return Math.min(countA, countB) * gain;
    }
}