// https://leetcode.com/problems/largest-triangle-area/

class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double area = calcArea(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public double calcArea(int[]p1,int[]p2,int[]p3){
        return 0.5 * Math.abs((double) ( p1[0]*(p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]) ));
    }
}