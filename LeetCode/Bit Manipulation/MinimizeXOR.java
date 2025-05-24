///  https://leetcode.com/problems/minimize-xor/description/

class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = Integer.bitCount(num2), ans = 0; 
        
        for(int i=31; i>=0 && count > 0; i--){
            if(((num1 >> i) & 1) == 1) {
               ans = ans ^ (1 << i);
               count--;
            }
        }

        for(int i=0; i<=31 && count > 0; i++){
            if(((ans >> i) & 1) == 0) {
               ans = ans ^ (1 << i);
               count--;
            }
        }
        return ans; 
    }
}