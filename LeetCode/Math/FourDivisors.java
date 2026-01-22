/// https://leetcode.com/problems/four-divisors/description/


class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0; 

        for(int num : nums){
            int c=2, sum=1+num;
            
            for(int i=2; i*i<= num && c<5; ++i){
                if(num % i == 0){
                    int div2 = num/i;
                    sum += i+div2;
                    c += (i == div2 ? 1 : 2);
                }
            }

            if(c == 4) ans += sum;
        }
        return ans;
    }
}