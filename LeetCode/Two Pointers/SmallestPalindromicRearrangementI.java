// https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/

class Solution {
    public String smallestPalindrome(String s) {
        char [] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] res = new char[chars.length];
        int l = 0, r = res.length - 1;
        int pt1 = 0, pt2 = 1;
        char midChar = 0;
        boolean hasMid = false;

        while (pt1 < chars.length) {
            if (pt2 < chars.length && chars[pt1] == chars[pt2]) {
                res[l++] = chars[pt1];
                res[r--] = chars[pt2];
                pt1 += 2;
                pt2 = pt1 + 1;
            } else {
                midChar = chars[pt1];
                hasMid = true;
                pt1++;
                pt2 = pt1 + 1;
            }
        }

        if (hasMid) {
            res[l] = midChar;
        }

        return new String(res);
    }
}