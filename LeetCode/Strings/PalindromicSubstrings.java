// https://leetcode.com/problems/palindromic-substrings

// T: O(n^2)           S: O(1)
class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++){
            int l = i, r = i;
            
            // For Odd Substrings
            while (s.charAt(l) == s.charAt(r)){ 
                res++;
                l--;
                r++;
                if (l < 0 || r >= s.length()) break;
            }

            l = i;
            r = i+1;
            // For Even Substrigns
            while (r < s.length() && s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
                if (l < 0 || r >= s.length()) break;
            }

        }
        return res;
    }
}