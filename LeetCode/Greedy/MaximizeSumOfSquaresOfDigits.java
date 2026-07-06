///  https://leetcode.com/problems/maximize-sum-of-squares-of-digits/description/

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        char[] arr = new char[num];

        for(int i=0; i<num; ++i){
            int digit = Math.min(sum, 9);
            
            sum -= digit;

            arr[i] = (char)(digit + '0'); 
        }

        if(sum > 0) return "";

        return new String(arr);
    }
}
