// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int[] maxBounds = new int[2];

        for (int i = 0; i < s.length(); i++){
            int l = i, r = i;
            while(s.charAt(l) == s.charAt(r)){
                if (r - l > maxBounds[1] - maxBounds[0]){
                    maxBounds[0] = l;
                    maxBounds[1] = r;
                }
                l--;
                r++;
                if (l < 0 || r >= s.length()) break;
            }

            l = i;
            r = i+1;
            while(r < s.length() && s.charAt(l) == s.charAt(r)){
                if (r - l > maxBounds[1] - maxBounds[0]){
                    maxBounds[0] = l;
                    maxBounds[1] = r;
                }
                l--;
                r++;
                if (l < 0 || r >= s.length()) break;
            }
        }
        return s.substring(maxBounds[0], maxBounds[1]+1);
    }
}