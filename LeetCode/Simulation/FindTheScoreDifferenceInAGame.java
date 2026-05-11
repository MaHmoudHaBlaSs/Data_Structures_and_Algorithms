///  https://leetcode.com/problems/find-the-score-difference-in-a-game/description/

class Solution {
    public int scoreDifference(int[] nums) {
        final boolean FIRST = true, SECOND = false;
        boolean active = FIRST;
        int score1 = 0, score2 = 0; 

        for(int i=0; i<nums.length; ++i){
            if((i+1)%6 == 0) active = !active;
            
            if((nums[i]&1) != 0) active = !active;

            if(active == FIRST) score1 += nums[i];
            else score2 += nums[i];  
        }

        return score1-score2; 
    }
}