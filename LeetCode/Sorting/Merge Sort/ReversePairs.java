// https://leetcode.com/problems/reverse-pairs/description/

class Solution {
    int res;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }
    public  void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        countPairs(arr, start, mid, end);
        merge(arr, start, mid, end);
    }
    private void countPairs(int[] arr, int start, int mid, int end) {
        int right = mid + 1;
        for (int left = start; left <= mid; left++) {
            // While left element > 2 * right element, all elements before 'right' are valid
            while (right <= end && (long) arr[left] > 2 * (long) arr[right]) {
                right++;
            }
            res += (right - (mid + 1));
        }
    }
    public  void merge(int[] arr, int start, int mid, int end) {
        int left = start, right = mid + 1, index = 0;
        int[] temp = new int[end - start + 1];

        // Merge the two halves into temp[]
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        // Copy remaining elements from the left half (if any)
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        // Copy remaining elements from the right half (if any)
        while (right <= end) {
            temp[index++] = arr[right++];
        }

        // Copy the sorted elements back into the original array
        for (int k = 0; k < temp.length; k++) {
            arr[start + k] = temp[k];
        }
    }
}