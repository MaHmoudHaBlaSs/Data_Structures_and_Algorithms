///  https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/description/

class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        char curr = 'z';
        
        while(n > 0){
            if(k - (curr -  'a') >= n) {
                sb.append(curr);
                k -= curr - 'a' + 1;
                n--;
            }
            else curr--;
        }
        
        while(k-- != 0) sb.append('a');
        
        return sb.reverse().toString();
    }
}