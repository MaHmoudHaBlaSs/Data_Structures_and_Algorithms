// https://leetcode.com/problems/circular-sentence/description/


class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            char lastChar = words[i].charAt(words[i].length() - 1);
            char firstChar = words[(i + 1) % n].charAt(0);
            if (lastChar != firstChar) {
                return false;
            }
        }
        return true;
    }
}