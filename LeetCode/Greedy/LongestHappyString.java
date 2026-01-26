///  https://leetcode.com/problems/longest-happy-string/description/

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[]{a,b,c};

        int n = a+b+c;
        for(int i=0; i<n; ++i){
            int best = -1;
            for(int j=0; j<3;++j){
                if(freq[j] > 0 && canAppend(sb, (char)('a'+j)) && (best == -1 || freq[best] < freq[j])){
                    best = j;
                }
            }
            
            if(best == -1) break;
            
            sb.append((char)('a'+best));
            freq[best]--;
        }
        
        return sb.toString();
    }
    
    private boolean canAppend(StringBuilder sb, char c){
        int n = sb.length();
        return !(n!=0 && (sb.charAt(sb.length()-1) == c) && ((n-2>=0) && sb.charAt(n-2) == c));
    }
}