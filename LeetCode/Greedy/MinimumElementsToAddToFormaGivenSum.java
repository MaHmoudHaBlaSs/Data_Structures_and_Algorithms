/// https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/description/

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        
        for(int n : nums) sum += n;

        long diff = Math.abs(sum - goal); 

        return diff == 0 ? 0 : (int)Math.ceilDiv(diff, limit); 
    }
}