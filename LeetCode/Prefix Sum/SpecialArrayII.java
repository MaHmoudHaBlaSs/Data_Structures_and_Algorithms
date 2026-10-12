///  https://leetcode.com/problems/special-array-ii/description/

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] violations = new int[nums.length];

        for(int i=1; i<nums.length; ++i){
            if(nums[i]%2 == nums[i-1]%2) 
                violations[i] = violations[i-1]+1;
            else violations[i] = violations[i-1];
        }

        boolean[] ans = new boolean[queries.length];
        for(int i=0; i<queries.length; ++i){
            int f = queries[i][0], t = queries[i][1];

            if(violations[f] == violations[t]) ans[i] = true;
        }

        return ans;
    }
}