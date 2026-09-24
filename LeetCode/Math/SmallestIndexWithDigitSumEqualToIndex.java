// https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/

class Solution {
    public int smallestIndex(int[] nums) {
        int res = -1 ;
        for(int i = 0 ; i < nums.length ; i++){
            int sum = 0 ;
            int n = nums[i];
            while(n > 0){
                sum += (n%10);
                n = n / 10;;  
            }
            if(sum == i){
                res =i ;
                break;
            }
        }
        return res;
    }
}