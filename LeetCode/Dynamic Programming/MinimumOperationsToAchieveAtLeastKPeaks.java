///  https://leetcode.com/problems/minimum-operations-to-achieve-at-least-k-peaks/description/


class Solution {
    private static final int oo = 0x3f3f3f3f;

    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if (k > n/2) return -1;

        int[][] memo = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], oo);
        }
        
        int ans = solve(0, k, n-1, nums, memo);
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], oo);
        }
        
        int op2 = solve(1, k, n, nums, memo);
        if(ans == -1) ans = op2;
        else ans = Math.min(ans, op2);
        
        return ans; 
    }

    private int solve(int i, int k,int n, int[] nums, int[][] memo){
        if(k == 0) return 0;
        if(i >= n || k > ((n-i)/2)+1) return -1;
        
        if(memo[i][k] != oo) return memo[i][k];

        int ans = oo;
        int op1 = solve(i+1, k, n, nums, memo);
        if(op1 != -1) ans = op1;

        int op2 = solve(i+2, k-1, n, nums, memo);
        if(op2 != -1){
            int prev = i==0? nums[nums.length-1] : nums[i-1];
            int next = i==nums.length-1 ? nums[0] : nums[i+1]; 
            ans = Math.min(ans, 
                    op2 + Math.max(0, 
                        Math.max(prev, next) - nums[i] + 1));
        }

        if(ans == oo) ans = -1; 
        
        return memo[i][k] = ans;
    }
 
}