--> https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=sorting

public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0 , right = 0 ,k = 0;
        int []result = new int[n+m];

        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                result[k++] = nums1[left++];
            } else {
                result[k++] = nums2[right++];
            }
        }

        while (left < m) {
            result[k++] = nums1[left++];
        }

        while (right < n) {
            result[k++] = nums2[right++];
        }

        System.arraycopy(result, 0, nums1, 0, n + m);
    }
