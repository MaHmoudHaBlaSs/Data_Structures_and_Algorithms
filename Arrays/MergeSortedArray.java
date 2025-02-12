// https://leetcode.com/problems/merge-sorted-array/description/

class Solution {
  
    // T: O(n+m)       S: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int swapper = nums1.length-1, i = m-1, j = n-1;

        while (i >= 0 && j >= 0){
            if (nums1[i] >= nums2[j]){
                nums1[swapper] = nums1[i];
                i--;
            }else{
                nums1[swapper] = nums2[j];
                j--;
            }
            swapper--;
        }
        while (j >= 0){
            nums1[swapper] = nums2[j];
            j--; swapper--;
        }
        while (i >= 0){
            nums1[swapper] = nums1[i];
            i--; swapper--;
        }
    }
}
