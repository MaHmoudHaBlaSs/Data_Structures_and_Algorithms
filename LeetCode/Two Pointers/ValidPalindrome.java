--> https://leetcode.com/problems/valid-palindrome/description/

public static boolean isPalindrome(String s) {

        int right = 0, left = s.length() - 1;
        s = s.toUpperCase();
        while(left >= right){

            if(!Character.isLetterOrDigit(((Character) s.charAt(left)))){
                left --;
                continue;
            }
            if(!Character.isLetterOrDigit(((Character) s.charAt(right)))){
                right++;
                continue;
            }
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
