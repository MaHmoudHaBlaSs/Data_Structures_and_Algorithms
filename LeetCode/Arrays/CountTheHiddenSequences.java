///   https://leetcode.com/problems/count-the-hidden-sequences/description/

class Solution {
    public int numberOfArrays(int[] differences, long lower, long upper) {  
        long sum = 0, min = 0 , max = 0; //long to prevent overflow 
        
        for(int i=0; i<differences.length; i++){
            sum += differences[i]; 

            if(sum < min) min = sum;
            if(sum > max) max = sum;
        }

        lower = lower - min; 
        upper = upper - max;

        if(lower <= upper) 
            return (int)(upper - lower) + 1;

        return 0; 
    }
}