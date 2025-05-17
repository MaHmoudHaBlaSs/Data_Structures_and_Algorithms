//https://leetcode.com/problems/median-of-two-sorted-arrays/


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] temp = new int[nums1.length + nums2.length];
        int i = 0 , j = 0 , k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            }else{
                temp[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            temp[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            temp[k++] = nums2[j++];
        }

        if (temp.length % 2 == 0) {
            return ( (double)temp[temp.length / 2]+ 0.0 + temp[temp.length / 2 - 1 ]) / 2;
        }
        return temp[temp.length / 2];
    }
}
