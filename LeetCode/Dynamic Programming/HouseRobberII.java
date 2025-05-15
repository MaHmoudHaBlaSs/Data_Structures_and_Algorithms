// https://leetcode.com/problems/house-robber-ii/


// T: O(n)                 S: O(n)
class Solution {
    int[] memo;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 2) 
            return Math.max(nums[0], (n == 2)?nums[1]:0);

        memo = new int[n+1];
        Arrays.fill(memo, -1);
        
        // // If first house Included, Remove last
        int opt1 = recurseDp(0, Arrays.copyOfRange(nums, 0, n-1)); 
        Arrays.fill(memo, -1); // Reset Memo 
        // If first house Excluded, Include Last
        int opt2 = recurseDp(1, nums);

        return Math.max(opt1, opt2);
    }

    public int recurseDp(int i, int[] houses){
        if (i >= houses.length) return 0;
        if (memo[i] != -1) return memo[i];

        memo[i] = Math.max(recurseDp(i+2, houses) + houses[i], recurseDp(i+1, houses));
        return memo[i];
    }
}