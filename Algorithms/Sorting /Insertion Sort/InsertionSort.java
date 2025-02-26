import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test Code
        int[] nums = {32, 15, 2, 17, 19, 26, 41, 17, 17};
        insertionSort(nums);
        for (int num: nums)
            System.out.print(num+" ");
    }
    // T: O(n2)          S: O(1)
    public static void insertionSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int key = nums[i];
            for (int j = i-1; j >= 0 && nums[j] > key; j--){
                nums[j+1] = nums[j];
                nums[j] = key;
            }
        }
    }
}