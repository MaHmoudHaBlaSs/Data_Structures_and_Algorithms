///  https://leetcode.com/problems/3sum-closest/description/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }

                if (sum > target)
                    r--;
                else if (sum < target) 
                    l++;
                else 
                    return sum; 
                
            }
        }
        return ans;
    }
}