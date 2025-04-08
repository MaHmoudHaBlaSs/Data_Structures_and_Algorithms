///   https://leetcode.com/problems/partition-array-into-disjoint-intervals/


//Maintain a pointer 'left', and 'max' which is the max element form 0 to 'left'
//If nums[left to n] >= max then left is the answer

class Solution {
    public int partitionDisjoint(int[] nums) {
        int left = 0, max = nums[0]; 

        for(int i=1; i<nums.length; i++){
            if(nums[i] >= max) continue; 

            while(left < i){
                if(nums[left] > max) 
                    max = nums[left];
                left++;
            }
        }

        return left+1; 
    }
}