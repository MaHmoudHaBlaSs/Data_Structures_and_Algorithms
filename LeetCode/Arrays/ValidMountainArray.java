// https://leetcode.com/problems/valid-mountain-array/description/



class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int i = 1;

        // Check if there is an initial climb
        if (arr[0] >= arr[1]) return false;

        for (; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) return false;
            if (arr[i - 1] > arr[i]) {
                break;
            }
        }

        if (i == arr.length) {
            return false;
        }

        while (i < arr.length) {
            if (arr[i - 1] <= arr[i]) {
                return false;
            }
            i++;
        }

        return true;
    }
}