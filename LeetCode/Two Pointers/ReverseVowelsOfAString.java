https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=problem-list-v2&envId=string

class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }

            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I' || c == 'i';
    }
}
