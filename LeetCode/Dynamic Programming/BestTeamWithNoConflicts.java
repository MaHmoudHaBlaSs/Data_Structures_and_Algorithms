///  https://leetcode.com/problems/best-team-with-no-conflicts/description/

class Solution { 
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length, ans = 0;
        int[][] arr = new int [n][2];
        int[] dp = new int[n];    
        
        for(int i=0; i<n; i++) arr[i] = new int[]{ages[i], scores[i]};
        
        Arrays.sort(arr, (a,b) -> { //sort on ages then scores
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        }); 


        for(int i=0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j][0] == arr[i][0] || arr[j][1] <= arr[i][1]) 
                    dp[i] = Math.max(dp[j], dp[i]); 
            }
            dp[i] += arr[i][1]; 
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}