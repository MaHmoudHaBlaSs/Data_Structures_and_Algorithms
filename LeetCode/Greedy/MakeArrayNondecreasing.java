/// https://leetcode.com/problems/make-array-non-decreasing/description/

class Solution {
    public int maximumPossibleSize(int[] nums) {
        int ans = 0, prev = -1;

        for(int num : nums){
            if(num >= prev){
                ans++; 
                prev = num; 
            }
        }

        return ans;
    }
}