///  https://leetcode.com/problems/maximum-product-of-three-elements-after-one-replacement/description/

class Solution {
    public long maxProduct(int[] nums) {
        int max = -1, beforeMax = 0;
        
        for(int num : nums){
            num = Math.abs(num);

            if(num >= max){
                beforeMax = max;
                max = num;
            }else if(num > beforeMax){
                beforeMax = num;
            }
        }

        return 1_000_00L * max * beforeMax;
    }
}