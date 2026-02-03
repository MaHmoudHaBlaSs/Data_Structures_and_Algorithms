// https://leetcode.com/problems/license-key-formatting/description/


class Solution {    
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = chars.length - 1; i >= 0; i--) {
            if((chars[i] != '-')&& count <= k) {
                if(count == k) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(chars[i]);
                count++;
                
            }
        }
        return sb.reverse().toString();
        
    }
}