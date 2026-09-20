/// https://leetcode.com/problems/minimum-levels-to-gain-more-points/description/

class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length; 
        int[] prefix = new int[n+1];

        for(int i=0; i<n; ++i){
            prefix[i+1] = prefix[i] + (possible[i] == 1 ? 1 : -1);
        }

        for(int i=1; i<n; ++i){
            if(prefix[i] > prefix[n] - prefix[i]) return i;
        }

        return -1;
    }
}