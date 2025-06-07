///  https://leetcode.com/problems/split-two-strings-to-make-palindrome/description/

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return is(a, b) || is(b, a);
    }

    private boolean is(String a, String b) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++; j--;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) 
            if (s.charAt(left++) != s.charAt(right--)) return false;
        
        return true;
    }
}


