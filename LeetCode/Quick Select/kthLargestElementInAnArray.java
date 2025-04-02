https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=problem-list-v2&envId=quickselect


// Best Case O(N)     Worst Case O(N^2) 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;
        int left = 0, right = nums.length - 1;
        return quickSelect(nums, left, right, targetIndex);
    }

    public int quickSelect(int[] nums, int low, int high, int target) {
        while (low <= high) { 
            int index = partition(nums, low, high);
            if (index == target) {
                return nums[index]; 
            } else if (index > target) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }
        return nums[target]; 
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int j = left - 1;
        for (int i = left; i <= right - 1; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        j++;
        swap(nums, j, right);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
