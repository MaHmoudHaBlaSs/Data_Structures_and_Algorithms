///  https://leetcode.com/problems/ways-to-make-a-fair-array/description/

class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalEvens = 0, totalOdds = 0;
        boolean isEven = true;
        
        for(int n : nums){
            if(isEven) totalEvens += n;
            else totalOdds += n;

            isEven = !isEven;
        }

        isEven = true;
        int previousEvens = 0, previousOdds = 0;
        int ans = 0;
        
        for(int n : nums){
            int evenSum = previousEvens + (totalOdds - (previousOdds + (isEven ? 0 : n)));
            int oddSum = previousOdds + (totalEvens - (previousEvens + (isEven ? n : 0)));
            
            if(evenSum == oddSum) ans++;
            
            if(isEven) previousEvens += n; 
            else previousOdds += n;

            isEven = !isEven;
        }

        return ans; 
    }
}