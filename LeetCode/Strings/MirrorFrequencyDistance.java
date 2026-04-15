/// https://leetcode.com/problems/mirror-frequency-distance/description/


class Solution {
    public int mirrorFrequency(String s) {
        int[] freqCh = new int[26], freqNum = new int[10]; 

        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);

            if(Character.isDigit(ch))
                ++freqNum[ch-'0'];
            else 
                ++freqCh[ch-'a'];
        }


        int ans = 0;
        for(int i=0; i<13; ++i){
            ans += Math.abs(freqCh[i]-  freqCh[25-i]);
        }

        for(int i=0; i<5; ++i){
            ans += Math.abs(freqNum[i]-  freqNum[9-i]);
        }

        return ans;        
    }
}