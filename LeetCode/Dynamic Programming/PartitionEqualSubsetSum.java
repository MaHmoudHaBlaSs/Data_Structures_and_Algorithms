/// https://leetcode.com/problems/partition-equal-subset-sum/description/


class Solution {
    private int[] nums;
    private boolean[][] vis;

    private boolean solve(int i, int s1,int s2){
        if(i == nums.length) 
            return s1 == s2;
        
        if(vis[i][s1]) 
            return false;

        if(solve(i+1, s1+nums[i], s2) || solve(i+1, s1, s2+nums[i]))
            return true;

        vis[i][s1] = true; 
        return false;
    }

    public boolean canPartition(int[] nums) {
        vis = new boolean[nums.length][20001];
        this.nums = nums;
        return solve(0,0,0);
    }
}