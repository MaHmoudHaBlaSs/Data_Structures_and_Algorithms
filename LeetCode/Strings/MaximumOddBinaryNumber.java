// https://leetcode.com/problems/maximum-odd-binary-number/description/

class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        
        int countOnes = 0;
        
        for (char c : chars) {
            if (c == '1') countOnes++;
        }
        if (countOnes == 0) return s; 
        
        for (int i = 0; i < countOnes - 1; i++) {
            chars[i] = '1';
        }
        for (int i = countOnes - 1; i < chars.length - 1; i++) {
            chars[i] = '0';
        }
        chars[chars.length - 1] = '1';
        
        return new String(chars);
    }
}