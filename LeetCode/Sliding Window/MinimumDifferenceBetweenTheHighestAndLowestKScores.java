https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/?envType=problem-list-v2&envId=sliding-window

public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE, left = 0, right = 0;
        while (left + k -1 < nums.length) {
            right = left + k -1 ;        
            res = Math.min(res, nums[right] - nums[left]);
            left++;
        }
        return res;
    }
