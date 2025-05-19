///  https://leetcode.com/problems/broken-calculator/description/

/*
If the current target is even: 
    it's a multiple of 2 so the answer is = 1 +  brokenCalc(startValue, target /2)
If the current target is odd: 
    it was a multiple of 2 then decreased by one, answer is = 2 +  brokenCalc(startValue, (target+1) /2)
*/

class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue >= target) 
            return startValue - target;

        if((target & 1) == 1) 
            return 2 + brokenCalc(startValue, (target +1) /2);
        
        return 1 +  brokenCalc(startValue, target /2);
    }
}