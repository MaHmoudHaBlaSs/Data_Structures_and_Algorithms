import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {12, 5, 23, 9, 45, 17, 1, 30, 5, 17, 8, 19}; // n = 7
        heapSort(nums);
        for (int num: nums)
            System.out.print(num+" ");
        System.out.println();
    }

    // Heap sort is the process of creating heap and removing of its elements
    // which is O(n) + O(nLog(n))
    // T: O(nLog(n))           S: O(1) in-place , it just costs space for recursion of heapifying
    public static void heapSort(int[] nums){
        buildHeap(nums);
        int len = nums.length;
        while(len > 1){
            swap(nums, 0, len-1);
            heapify(nums, 0, len-1);
            len--;
        }
    }

    // T: O(n) NOT O(nLog(n)) because we start from n/2 and won't cost log(n) for most of the nodes by summation it
    // will sum up to O(n)
    public static void buildHeap(int[] nums){
        for (int i = nums.length/2 - 1; i >= 0; i--)
            heapify(nums, i, nums.length);
    }

    // T: O(Log(n)
    public static void heapify(int[] nums, int i, int len){
        int left = 2*i+1, right = 2*i+2;
        int max;

        if (left >= len && right >= len) return;
        else if (left >= len) max = right;
        else if (right >= len) max = left;
        else max = (nums[right] > nums[left])?right:left;

        if (nums[max] > nums[i]){
            swap(nums, max, i);
            if (max < len/2)
                heapify(nums, max, len);
        }
    }

    public static void swap (int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}