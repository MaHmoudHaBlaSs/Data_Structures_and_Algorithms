///    https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/

class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length()-1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) break;

            char c = s.charAt(left);
            while(left <= right && s.charAt(left) == c) left++;
            while(left <= right && s.charAt(right) == c) right--;
        }

        return right - left+1;
    }
}