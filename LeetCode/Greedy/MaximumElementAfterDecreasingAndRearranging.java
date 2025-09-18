///  https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description/

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr); 

        int prev = 0; 
        for(int num : arr){
            if(num - prev > 1) ++prev;
            else prev = num; 
        }

        return prev; 
    }
}