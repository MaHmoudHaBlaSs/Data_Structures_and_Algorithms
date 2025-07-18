/// https://leetcode.com/problems/sum-game/description/

class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftS = 0, rightS = 0, leftQ = 0, rightQ = 0;

        for (int i = 0; i < n/2; i++) {
            if(num.charAt(i) == '?') leftQ++;
            else leftS += num.charAt(i) - '0';
        }

        for (int i = n/2; i < n; i++) {
            if(num.charAt(i) == '?') rightQ++;
            else rightS += num.charAt(i) - '0';
        }

        if((leftS > rightS && leftQ >= rightQ ) || (leftS < rightS && leftQ <= rightQ ))
            return true;

        if(leftS == rightS && leftQ != rightQ) 
            return true; 
        
        int diffS = Math.abs(rightS - leftS), diffQ = Math.abs(leftQ - rightQ);

        return canAliceWine(diffS, diffQ - (diffQ/2) ,diffQ/2); 

    }
    
    private boolean canAliceWine(int diff, int aliceQ, int bobQ){
        return aliceQ * 9 >  diff || bobQ * 9 < diff;
    }
}