///  https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/description/

/*
-Straight-forward solution is to consider the state is maxScore(i, left, right), where left and right are pointers to the current 
start, end indices on the nums array.

-You can simply reduce this state by computing the right index using => right = n - 1 - (i - left)
*/

class Solution {
    private final int oo = 0x3f3f3f3f;
    private int n,m;
    private int[] nums, multipliers;
    private int[][] memo;

    private int maxScore(int i,int left){
        if(i >= m) return 0;

        if(memo[i][left] != oo) return memo[i][left];

        int right = n - (i - left) - 1;

        int op1 = multipliers[i]*nums[left] + maxScore(i+1,left+1);
        int op2 = multipliers[i]*nums[right] + maxScore(i+1,left);

        return memo[i][left] = Math.max(op1, op2);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length; m = multipliers.length;
        memo = new int[m][n];
        this.nums = nums; this.multipliers = multipliers;

        for(int i=0; i<m; i++) Arrays.fill(memo[i], oo);

        return maxScore(0,0); 
    }
}