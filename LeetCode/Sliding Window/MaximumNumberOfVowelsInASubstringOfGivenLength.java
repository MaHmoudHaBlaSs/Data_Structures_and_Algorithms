// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75


class Solution {
    public int maxVowels(String s, int k) {
        int max = 0, current = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            
            if (isVowel(s.charAt(right))) {
                current++;
            }

            
            if (right - left + 1 > k) {
                if (isVowel(s.charAt(left))) {
                    current--;
                }
                left++;
            }

            
            if (right - left + 1 == k) {
                max = Math.max(max, current);
            }

            right++;
        }

        return max;
    }
    public boolean isVowel(char ch ){
        return (ch == 'a' || (ch == 'o') || (ch == 'i') || ch == 'u' || (ch == 'e'));
    }
    
}
