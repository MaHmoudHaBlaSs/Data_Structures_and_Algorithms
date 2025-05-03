// https://leetcode.com/problems/reverse-words-in-a-string/description/

class Solution {
    public String reverseWords(String s) {
        String []words = s.trim().split("\\s+"); // \\s+  بتشيل اي مسافات فاضيه او حتي لو نزل سطر جديد
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i == 0 ) break;
            sb.append(" ");
        }
        return sb.toString();

    }
}