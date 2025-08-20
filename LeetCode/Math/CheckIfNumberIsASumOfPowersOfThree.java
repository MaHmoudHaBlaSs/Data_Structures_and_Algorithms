///  https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/

class Solution {
    public boolean checkPowersOfThree(int n) {
        int power = 15;
        
        while(power > -1){
            int powerOf3 = (int)Math.pow(3,power);
            
            if(n >= powerOf3) n -= powerOf3;
            
            power--;
        }

        return n == 0;
    }
}