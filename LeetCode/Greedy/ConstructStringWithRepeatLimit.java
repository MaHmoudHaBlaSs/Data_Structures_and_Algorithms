///  https://leetcode.com/problems/construct-string-with-repeat-limit/description/

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];

        for(int i=0; i<s.length(); ++i){
            freq[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0, prev = -1;

        for(int i=0; i<s.length(); ++i){
            int best = -1;

            for(int j=25; j>=0; --j){
                if(freq[j] == 0) continue;

                if(prev == j && count == repeatLimit){
                    continue;
                }else{
                    best = j;
                    freq[j]--;
                    break;
                }                
            }

            if(best == -1) break;

            sb.append((char)('a'+best));

            if(best == prev){
                count++;
            }
            else{
                count = 1;
                prev = best;
            }
        } 

        return sb.toString();
    }
}