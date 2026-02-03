// https://leetcode.com/problems/repeated-substring-pattern/description/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length(); 
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                int repeats = n / i;
                
                for (int j = 0; j < repeats; j++) {
                    sb.append(sub);
                }
                
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}