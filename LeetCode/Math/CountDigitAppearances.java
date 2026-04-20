///  https://leetcode.com/problems/count-digit-appearances/description/

class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0; 

        for(int num : nums){
            while(num > 0){
                if(num%10 == digit){
                    ++ans;
                }
                num /= 10; 
            }
        }

        return ans;
    }
}