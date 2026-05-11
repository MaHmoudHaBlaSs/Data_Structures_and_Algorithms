///  https://leetcode.com/problems/maximum-bitwise-xor-after-rearrangement/description/

class Solution {
    public String maximumXor(String s, String t) {
        int ones = 0, zeros = 0, n = t.length(); 
        for(int i=0; i<n; ++i){
            if(t.charAt(i) == '1') ++ones;
        }

        zeros = n-ones; 
        StringBuilder sb = new StringBuilder(n); 

        for(int i=0; i<n; ++i){
            if(s.charAt(i) == '1'){
                if(zeros-- > 0){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                    --ones;
                }
            }else{
                if(ones-- > 0){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                    --zeros;
                }
            }
        }

        return sb.toString();
    }
}
