// https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/


class Solution {
    public long sumAndMultiply(int n) {
        String num = "";
        long sum = 0;
        while(n > 0){
            
            if (n % 10 != 0) {
                num += n % 10;
                sum += n % 10;
            } 
            n /= 10;
        
        }

        if(sum == 0 )return 0;
        
        return sum * Long.parseLong(new StringBuilder(num).reverse().toString());  
    }
}