/// https://leetcode.com/problems/complete-prime-number/description/

class Solution {
    public boolean completePrime(int num) {
        int prefix = num, suffix = 0, i = 1; 

        while(prefix > 0){
            if(!isPrime(prefix) || !isPrime(suffix))
                return false;
        
            int digit = prefix % 10;
            prefix /= 10;
            suffix += i * digit;
            i *= 10; 
        }

        return true;
    }

    private boolean isPrime(int num){
        if(num == 1) return false;

        if(num < 4) return true;

        for(int i=2; i*i<=num; ++i){
            if(num%i == 0) return false;
        }

        return true; 
    }
}