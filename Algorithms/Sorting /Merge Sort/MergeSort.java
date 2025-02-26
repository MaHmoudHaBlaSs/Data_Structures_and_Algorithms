import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test Code
        int[] nums = {32, 15, 2, 17, 19, 26, 41, 17, 17};
        mergeSort(nums, 0, nums.length-1);
        for (int num: nums)
            System.out.print(num+" ");
    }
    
    // T: O(nLog(n))         S: O(n)
    public static void mergeSort(int[] nums, int start, int end){
        // Every time we split we get two arrays of n/2 length
        // so to know how many times we would split (recurse) an array of n size we will take the log2(n) [length of the tree]

        // T: O(log(n))
        if (start < end){ 
            int mid = (start+end)/2;
            // Spliting
            mergeSort(nums, start, mid);   // T:O(log(n))         S: O(1)
            mergeSort(nums, mid+1, end);   // T:O(log(n))         S: O(1)
            merge(nums, start, mid, end);  // T:O(n) * O(log(n))  S: O(n)
        }
    }
    // T: O(n)    S: O(n)
    public static void merge(int[] nums, int start, int mid, int end){
        // Arr 1 start -> mid
        // Arr 2 mid+1 -> end
        int[] leftArr = new int[mid-start+1], rightArr = new int[end-mid];
        int ind1 = 0, ind2 = 0;
        
        for (int i = 0; i < leftArr.length; i++)
            leftArr[i] = nums[start+i];
        for (int i = 0; i < rightArr.length; i++)
            rightArr[i] = nums[mid+i+1];
        
        ind1 = 0; ind2 = 0; 
        while (ind1 < leftArr.length && ind2 < rightArr.length){
            if (leftArr[ind1] <= rightArr[ind2])
                nums[start++] = leftArr[ind1++];                
            else
                nums[start++] = rightArr[ind2++];
        }
        while (ind1 < leftArr.length)
            nums[start++] = leftArr[ind1++];
        while (ind2 < rightArr.length)
            nums[start++] = rightArr[ind2++];
    }
}
