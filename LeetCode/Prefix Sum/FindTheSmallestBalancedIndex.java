///  https://leetcode.com/problems/find-the-smallest-balanced-index/description/


class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long product = 1, sum = 0;
        int ans = -1; 

        for(int i=0; i<nums.length; ++i){
            sum += nums[i]; 
        }

        int j=nums.length-1;
        while(product <= sum && j>=0){
            sum -= nums[j];

            if(product == sum) ans=j;

            try{
                product = Math.multiplyExact(product, nums[j--]);
            }catch (Exception e){
                break;
            }
        }

        return ans;
    }
}