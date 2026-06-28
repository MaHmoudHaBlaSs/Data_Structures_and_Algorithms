///  https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/

class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for(int i=num1; i <= num2; ++i){
            int curr = i;
            int prevDigit = curr % 10, currDigit, nextDigit;
            curr /= 10;

            while(curr >= 10){
                currDigit = curr % 10;
                curr /= 10;

                nextDigit = curr % 10;
                if((currDigit > prevDigit && currDigit > nextDigit)|| 
                    (currDigit < prevDigit && currDigit < nextDigit))
                    ans++;                   

                prevDigit = currDigit;
            }
        }

        return ans;
    }
}