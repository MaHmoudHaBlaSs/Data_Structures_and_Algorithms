import java.util.*;

// Quick Select is used when you need to:
// Find the k-th smallest element
// Find the k-th largest element
// Find the median
// Top-k smallest/largest elements (sometimes used in combination with sorting/trimming)

public class Main {
    public static void main(String[] args) {
        // Test Code
        int[] nums = {32, 15, 2, 17, 19, 26, 41, 17, 17};
        quickSelect(nums, 0, nums.length-1);
        for (int num: nums)
            System.out.print(num+" ");
    }
    
    
    // T: O(n^2) for duplicates and ordered input - Ω(nLog(n)) for Shuffled input. [n+n/2+n/4+n/8....]
    // S: O(n) for duplicates and ordered input - Ω(Log(n)) for Shuffled input.

    // Arr [start, end] -> Inclusive
    public static void kSmallestQuickSelect(int[] nums, int start, int end){
        if (start < end){
            // Just Consider the part of the array that we knows our Kst element lays on it.
            int partitionInd = partition(nums, start, end);
            if (partitionInd == k) return nums[k];
            if (partitionInd > k ) quickSort(nums, start, partitionInd-1);
            else quickSort(nums, partitionInd+1, end);
        }
    }
    // Hoare's Partitioning [Always Left Most as Pivot] >> Best Approach when applied to shuffled array.
    // T: O(n)
    public static int partition(int[] nums, int i, int j){
        int pivot = i;
        while (i < j){
            while (nums[pivot] >= nums[i]) i++;
            while (nums[pivot] < nums[j]) j--;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, pivot, j);
        return j;
    }
}
