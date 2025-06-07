// https://leetcode.com/problems/palindrome-number/

// T: O(n)          S: O(n.length) >> converting number (32) to number length
class Solution {
    public boolean isPalindrome(int x) {
        String num = x+"";

        for (int i = 0, j = num.length()-1; i < j; i++, j--){
            if (num.charAt(i) != num.charAt(j)) return false;
        }
        return true;
    }
}