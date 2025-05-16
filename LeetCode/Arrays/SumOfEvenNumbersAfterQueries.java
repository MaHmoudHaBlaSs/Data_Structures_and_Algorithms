///   https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/


class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length, sum = 0;
        int[] ans = new  int[n];

        for(int num : nums) 
            if((num & 1) == 0) sum += num; 

        for(int i=0; i<n; i++){
            int num = nums[queries[i][1]];
            if((num & 1) == 0) sum -= num; 

            num += queries[i][0];
            if((num & 1) == 0) sum += num; 

            nums[queries[i][1]] = num;
            ans[i] = sum; 
        } 

        return ans;
    }
}