///  https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topFreq = new int[7], bottomFreq = new int[7], common = new int[7]; 
        int n = tops.length; 

        for(int i=0; i<n; i++){
            topFreq[tops[i]]++; 
            bottomFreq[bottoms[i]]++;

            if(tops[i] == bottoms[i]) 
                common[tops[i]]++;     
        }

        for(int i=1; i<7;i++){
            if(topFreq[i] + bottomFreq[i] - common[i] >= n)
                return n - Math.max(topFreq[i], bottomFreq[i]);
        }

        return -1; 
    }
}