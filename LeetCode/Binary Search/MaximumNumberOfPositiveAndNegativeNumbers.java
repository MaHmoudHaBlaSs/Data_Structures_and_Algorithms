https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/?envType=problem-list-v2&envId=binary-search

public static int maximumCount(int[] nums) {

        return Math.max(NegativeCount(nums), PositiveCount(nums));
    }
    public static int NegativeCount(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] >= 0) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static int PositiveCount(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] <= 0) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return nums.length - low ;
    }
