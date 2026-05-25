// https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/

class Solution {
    
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        if (n <= 2) return nums;
        
        int[] result = new int[n];
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int size1 = 1, size2 = 1;
        
        for (int i = 2; i < n; i++) {
            if (arr1[size1 - 1] > arr2[size2 - 1]) {
                arr1[size1++] = nums[i];
            } else {
                arr2[size2++] = nums[i];
            }
        }
        
        
        System.arraycopy(arr1, 0, result, 0, size1);
        System.arraycopy(arr2, 0, result, size1, size2);
        
        return result;
    }

}