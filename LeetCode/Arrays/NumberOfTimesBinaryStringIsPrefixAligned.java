/// https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/description/

class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0, max = 0; 
        
        for(int i=0; i<flips.length; ++i){
            if(flips[i] > max) 
                max = flips[i];

            if(i+1 == max) 
                ++ans;
        }   

        return ans; 
    }

}