// https://leetcode.com/problems/repeated-string-match/description/ 

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        StringBuilder sb = new StringBuilder(a);

        
        int maxLimit = b.length() + (2 * a.length());

        while (sb.length() <= maxLimit) {
            if (sb.toString().contains(b)) {
                return count;
            }
            sb.append(a);
            count++;
        }
        
        return -1;
    }
}