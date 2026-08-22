///   https://leetcode.com/problems/predict-the-winner/description/


/*
    Basically, this is a Minimax problem, the classical approach to solve it would be
    having a function where each player trys to maximizes its score:
    play(P1 or P2, left, right) -> (P1 score, P2 score)
    P1 -> maximize P1 score , P2 -> maximize P2 score.

    To apply DP on it we will need dp[P1 or P2][left][right][P1 score, P2 score] 
*/

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] res = minimax(true, 0, n-1, nums);
        return res[0] >= res[1]; 
    }
  
    private int[] minimax(boolean isPlayer1, int left, int right, int[] nums){
        if ( left == right ) 
            return (isPlayer1)? new int[]{nums[left], 0}: new int[]{0, nums[left]};


        if ( isPlayer1 ) {
            int[] leftScore = minimax(false, left+1, right, nums);
            int[] rightScore = minimax(false, left, right-1, nums);
            leftScore[0] += nums[left];
            rightScore[0] += nums[right];
            return (leftScore[0] >= rightScore[0])? leftScore: rightScore;
        } 
        else {
            int[] leftScore = minimax(true, left+1, right, nums);
            int[] rightScore = minimax(true, left, right-1, nums);
            leftScore[1] += nums[left];
            rightScore[1] += nums[right];
            return (leftScore[1] >= rightScore[1])? leftScore: rightScore;
        }
    }
}

 /* 
    Another approach for applying Minimax but in different prespective, each player maximize the difference by
    currentPlayerScore - otherPlayerBestScore(recursively) => the +ve diff is for P1 and -ve diff is for P2,
    that single formulation works for both players with no need to keep track of which player is playing,
    Ex: [1, 5, 2] (consider left branch)
    P1:                      1, 5, 2   
    |                       /          \ notices that the sign changed from +ve (1, 5) to -ve (-1, -5) 
    |                      /               \ returns max (5 - 1, 1 - 5) 
    P2:                 5, 2                   1, 5
    |                  /   \      returns 5   /   \  returns 1 
    P1: (Base Case)   2     5                5     1 
    
    Apply DP using dp[left][right]
 */


class Solution {
    int[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for ( int[] row: dp)
            Arrays.fill(row, -1);

        return play(0, n-1, nums) >= 0;
    }

    private int play(int left, int right, int[] nums){
        if ( left == right )
            return dp[left][right] = nums[left];

        if ( dp[left][right] != -1 )
            return dp[left][right];

        // the `-` sign will alternate level by level causing P11 to summate positives and P2 to summate negatives
        // (-) * (-) = (+)
        int leftPlay = nums[left] - play(left+1, right, nums);
        int rightPlay = nums[right] - play(left, right-1, nums);
        return dp[left][right] = Math.max(leftPlay, rightPlay);
    }
}


/*
Backtracking:
The max score player 1 can achieve is max of two options
    1-Take leftmost number `nums[i]` then let player 2 play optimally (let him choose between nums[i+1], nums[j])
        if player 2 chose nums[i+1] then next you will choose from nums[i+2] & nums[j].
        if player 2 chose nums[j] then next you will choose from nums[i+1] & nums[j-1].
    
    2-Take rightmost number `nums[j]` then let player 2 play optimally (let him choose between nums[i], nums[j-1])
        if player 2 chose nums[i] then next you will choose from nums[i+1] & nums[j-1].
        if player 2 chose nums[j-1] then next you will choose from nums[i] & nums[j-2].    
*/

//Time: O(2^n) 
class Solution {
    private int[] nums;
    private int[][] dp;

    private int solve(int i,int j){ //returns the maximum sum of numbers that player 1 can take
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int op1 = nums[i] + Math.min(solve(i+1,j-1), solve(i+2, j));
        int op2 = nums[j] + Math.min(solve(i+1,j-1), solve(i, j-2));

        return dp[i][j] = Math.max(op1, op2);
    }

    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        int sum = 0;
        for(int n : nums) sum += n;

        dp = new int[nums.length][nums.length];
        for(int i=0; i<nums.length; i++) Arrays.fill(dp[i], -1);
    
        int sol = solve(0,nums.length-1);
        return sol >= sum - sol;
    }
}