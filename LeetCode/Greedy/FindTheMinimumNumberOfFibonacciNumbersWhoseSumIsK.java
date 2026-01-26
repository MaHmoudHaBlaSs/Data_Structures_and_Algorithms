///  https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/description/ 

class Solution {
    public int findMinFibonacciNumbers(int k) {
        int prev1=1, prev2=1, curr = 2;

        while(curr < k){
            prev1 = prev2;
            prev2 = curr;
            curr += prev1;  
        }  

        int ans = 0;
        while(k > 0){
            if(k >= curr){
                k -= curr; 
                ++ans;
            }else{
                curr = prev2;
                prev2 = prev1;
                prev1 = curr - prev2;
            }
        }

        return ans;
    }
}