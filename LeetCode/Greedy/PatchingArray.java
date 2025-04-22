///  https://leetcode.com/problems/patching-array/description/

/*
[Important]: 
    if there is a part of the array nums[0 : i-1] and this part can form each number from 1 to currN and nums[i] <= currN
    then taking nums[i] will give us all numbers from 1 to currN + nums[i] 

-Consider n is a target we wnanna to get, starting from currN = 0, we will stop when currN >= n.
-Iterate through nums from left to right:
    if(nums[i] > currN+1) then there is a missing number so repeadtly add currN + 1 to the currN and count++.
*/


class Solution {
    public int minPatches(int[] nums, int n) {
        long currN = 0; 
        int count = 0; 

        for(int i=0; i<nums.length; i++){
            if(currN >= n) return count;

            while(currN < n && currN + 1 < nums[i]){
                currN += currN + 1;
                count++;
            }

            currN += nums[i]; 
        }

        while(currN < n){
            currN += currN + 1;
            count++;
        }

        return count; 
    }
}