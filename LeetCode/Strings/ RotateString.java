// https://leetcode.com/problems/rotate-string/

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;

        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) q.add(c);

        for (int i = 0; i < s.length(); i++) {
            q.add(q.poll()); // Rotate
            
            // Reconstruct string to compare
            StringBuilder sb = new StringBuilder();
            for (Character c : q) sb.append(c);
            
            if (sb.toString().equals(goal)) return true;
        }
        return false;
    }
}