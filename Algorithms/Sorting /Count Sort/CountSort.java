import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] nums = {12, 5, 23, 9, 45, 17, 1, 30, 5, 17, 8, 19}; // n = 7
        myCountSort(nums);
        for (int num: nums)
            System.out.print(num+" ");
        System.out.println();
    }
    /
    // T: O(N+M)          S: O(N+M)
    public static void countSort(int[] nums){
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sorted = new int[nums.length];
        int[] counts = new int[max+1];

        // Getting frequencies
        for (int i = 0; i < nums.length; i++)
            counts[nums[i]]++;

        // Getting the initial starting points (need to be right shifted)
        for (int i = 1; i < counts.length; i++)
            counts[i] += counts[i-1];

        // Right shifting
        for (int i = counts.length-1; i > 0; i--)
            counts[i] = counts[i-1];
        counts[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            sorted[counts[nums[i]]] = nums[i];
            counts[nums[i]]++;
        }

        // O(n)
        for (int i = 0; i < nums.length; i++)
            nums[i] = sorted[i];
    }
}