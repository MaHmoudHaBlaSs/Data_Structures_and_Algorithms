///  https://leetcode.com/problems/minimum-rectangles-to-cover-points/description/

class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a,b) -> a[0]-b[0]);

        int ans = 1, start = points[0][0];
        for(int[] point : points){
            if(point[0] - start > w){
                start = point[0];
                ans++;
            }
        }

        return ans;
    }
}