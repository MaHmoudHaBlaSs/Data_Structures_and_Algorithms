///  https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint/description/

class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder t = new StringBuilder(s.length());

        for(int i=0; i<s.length(); ++i){
            char c1 = s.charAt(i);
            char c2 = 'a';

            while(c2<='z'){
                int d = dist(c1, c2);
                if(d <= k){
                    k -= d;
                    break;
                }
                c2++;
            }

            t.append(c2);
        }

        return t.toString();
    }

    private int dist(char c1, char c2){
        int diff = Math.abs(c1-c2);
        return Math.min(diff, 26-diff);
    }
}