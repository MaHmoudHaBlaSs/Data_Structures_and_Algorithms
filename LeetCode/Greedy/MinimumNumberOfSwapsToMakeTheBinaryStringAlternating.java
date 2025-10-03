/// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/description/

class Solution {
    public int minSwaps(String s) {
        int c1 = 0, c2 = 0, ones = 0, n = s.length();
        char ch1 = '0', ch2='1'; 

        for(int i=0; i<n;++i){
            char ch = s.charAt(i);
            if(ch1 != ch) ++c1;
            if(ch2 != ch) ++c2;
            if('1' != ch) ++ones;

            char tmp = ch1;
            ch1 = ch2;
            ch2 = tmp; 
        }

        int allowed = (n&1) == 0 ? n/2 : (n/2) +1;
        if(ones > allowed || (n-ones) > allowed) return -1;

        int ans = Integer.MAX_VALUE;
        if((c1 & 1) == 0) ans = c1 / 2;
        if((c2 & 1) == 0) ans = Math.min(ans, c2 / 2);

        return ans == Integer.MAX_VALUE ? -1 : ans; 
    }
}