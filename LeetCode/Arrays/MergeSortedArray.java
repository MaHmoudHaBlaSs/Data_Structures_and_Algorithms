// https://leetcode.com/problems/merge-sorted-array/description/

class Solution {
  
    // T: O(n+m)       S: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m1 = m-1, m2 = n-1, writer = nums1.length-1;
        while (writer > m1 && m1 >= 0 && m2 >= 0){
            if (nums2[m2] >= nums1[m1])
                nums1[writer--] = nums2[m2--];
            else
                nums1[writer--] = nums1[m1--];
        }
        while (m1 == -1 && writer >= 0 && m2 >= 0)
            nums1[writer--] = nums2[m2--];
    }
}
