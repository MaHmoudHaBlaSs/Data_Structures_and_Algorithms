///  https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/description/

class Solution {
    public boolean validPartition(int[] nums) {
        return solve(0, nums, new boolean[nums.length]);
    }

    private boolean solve(int i, int[] nums, boolean[] vis){
        if(i >= nums.length) return true;

        if(vis[i]) return false;

        if(i < nums.length - 2){
            if(nums[i] == nums[i+1] && nums[i] == nums[i+2]){
                if(solve(i+3, nums, vis))
                    return true;
            }
            else if(nums[i] == nums[i+1]-1 && nums[i] == nums[i+2]-2){
                if(solve(i+3, nums, vis))
                    return true;
            }
        }

        if(i < nums.length - 1){
            if(nums[i] == nums[i+1]){
                if(solve(i+2, nums, vis))
                    return true;
            }
        }

        vis[i] = true;
        return false;
    }
}