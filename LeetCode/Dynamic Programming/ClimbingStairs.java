// https://leetcode.com/problems/climbing-stairs/

// Bottom-Up Dp [Tabulation]
// T: O(n)              S: O(n)  [n <= 45]
class Solution {
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int a = 1, b = 2  , x = 0 ;
        for (int i = 3; i <= n; i++) {
            x= a+b;
            a = b;
            b = x;
        }
        return x;
    }
}

// Top-Down DP [Memoization]
// T: O(n)              S: O(46)
class Solution {
    int[] solved = new int[46]; // Max = 45

    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1; // Base Case
        if (solved[n] != 0) return solved[n]; // Already Solved [Memoized]
        
        return solved[n] = climbStairs(n-1) + climbStairs(n-2); // Climb By 1 + Climb By 2
    }
}