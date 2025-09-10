/// https://leetcode.com/problems/minimum-sideway-jumps/description/


class Solution {
    private final int oo = 0x3f3f3f3f; 

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[4][n];

        for(int i=1; i<4; i++) Arrays.fill(dp[i], oo);

        dp[2][0] = 0; dp[1][0] = dp[3][0] = 1;

        for(int point=1; point<n; point++){
            for(int lane=1; lane <4; lane++){
                if(obstacles[point] == lane) continue; //unreachable lane at this point
                dp[lane][point] = dp[lane][point-1];
                for(int i=1; i<4; i++){
                    if(obstacles[point] == i) continue;//unreachable lane from dp[i][point-1]

                    dp[lane][point] = Math.min(
                        dp[lane][point],
                        dp[i][point-1] + (i == lane ? 0 : 1)
                    );
                }
            }
        }

        return Math.min(dp[1][n-1], Math.min(dp[2][n-1], dp[3][n-1]));
    }
}