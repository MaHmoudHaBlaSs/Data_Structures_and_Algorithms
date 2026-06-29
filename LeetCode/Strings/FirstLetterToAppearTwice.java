// https://leetcode.com/problems/first-letter-to-appear-twice/description/


class Solution {
    public char repeatedCharacter(String s) {
        int [] chars = new int [26];
        for (char c : s.toCharArray()) {
            if (chars[c - 'a'] == 1) {
                return c;
            }
            chars[c - 'a']++;
        }
        return ' ';
    }
}