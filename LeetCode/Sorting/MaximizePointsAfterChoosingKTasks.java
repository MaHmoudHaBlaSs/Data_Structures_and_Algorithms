///  https://leetcode.com/problems/maximize-points-after-choosing-k-tasks/description/

class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length;
        int[][] arr = new int[n][2];

        for(int i=0; i<n; ++i){
            arr[i][0] = technique1[i];
            arr[i][1] = technique2[i];
        }


        Arrays.sort(arr, (a,b) -> (b[0]-b[1]) - (a[0]-a[1]));

        long score = 0;
        for(int i=0; i<n; ++i){
            if(i<k) score += arr[i][0];
            else score += Integer.max(arr[i][0], arr[i][1]);
        }

        return score;
    }
}