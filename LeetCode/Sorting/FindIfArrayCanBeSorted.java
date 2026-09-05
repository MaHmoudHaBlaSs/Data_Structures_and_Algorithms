///  https://leetcode.com/problems/find-if-array-can-be-sorted/description/

class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length; 

        for(int i=0; i<n; ){
            int j=i+1, count = Integer.bitCount(nums[i]);
            
            while(j<n && count == Integer.bitCount(nums[j])){
                j++;
            }

            if(j > i+1) Arrays.sort(nums, i, j);

            i = j;
        }

        for(int i=1; i<n; ++i){
            if(nums[i] < nums[i-1]) return false;
        }

        return true;
    }
}