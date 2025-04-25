///  https://leetcode.com/problems/video-stitching/description/


class Solution {
    public int videoStitching(int[][] clips, int time) {
        int currTime = 0; 
        int count = 0; 

        while(currTime != -1 && currTime < time){
            currTime = maxTime(clips,currTime); 
            count++; 
        }

        return currTime == -1 ? -1 : count;
    }

    private int maxTime(int[][] clips, int start){
        int max = start; 

        for(int i=0; i<clips.length; i++){
            if(clips[i][0] <= start && clips[i][1] >= max){
                max = clips[i][1]; 
            }
        }

        if(max == start) 
            return -1;

        return max;
    }
}