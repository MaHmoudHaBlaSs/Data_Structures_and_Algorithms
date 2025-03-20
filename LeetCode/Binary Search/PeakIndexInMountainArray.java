///  https://leetcode.com/problems/peak-index-in-a-mountain-array/


//Time: O(log(n))       Space: O(1)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int ans = 0; 
        int left=0,right = arr.length-1;
        
        while(left <= right){
            int mid = (left+right) /2;

            if(mid == 0 || (mid - 1 >= 0 && arr[mid] >= arr[mid-1])){
                ans = mid; 
                left = mid+1;
            }
            else right=mid-1;
        }

        return ans; 
    }
}