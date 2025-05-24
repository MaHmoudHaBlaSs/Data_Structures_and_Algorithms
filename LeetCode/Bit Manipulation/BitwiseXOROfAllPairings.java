///  https://leetcode.com/problems/bitwise-xor-of-all-pairings/description/

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int mask = 0;
        if((nums2.length & 1) == 1){  
            for(int num : nums1)
                mask ^= num; 
        }

        if((nums1.length & 1) == 1){
            for(int num : nums2)
                mask ^= num;             
        }

        return mask;
    }
}