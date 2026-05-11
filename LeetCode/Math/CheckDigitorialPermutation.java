///   https://leetcode.com/problems/check-digitorial-permutation/description/

class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] fact = new int[10], freq = new int[10]; 
        fact[0] = fact[1] = 1; 

        for(int i=2; i<10; ++i) fact[i] = i * fact[i-1];

        int sum = 0;
        while(n > 0){
            int digit = n%10; 
            n /= 10; 

            sum += fact[digit];
            freq[digit]++;  
        }


        while(sum > 0){
            int digit = sum%10; 
            sum /= 10; 

            freq[digit]--;
        }

        for(int i=0; i<10; ++i)
            if(freq[i] != 0) return false;  

        return true; 
    }
}