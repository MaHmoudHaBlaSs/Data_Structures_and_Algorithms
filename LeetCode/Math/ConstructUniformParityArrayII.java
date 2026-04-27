/// https://leetcode.com/problems/construct-uniform-parity-array-ii/description/


class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for(int num : nums1)
            min = Integer.min(num,min);
        
        if((min & 1) == 1) return true;

        for(int num : nums1){
            if((num&1) == 1) return false;
        }
        return true;
    }
}