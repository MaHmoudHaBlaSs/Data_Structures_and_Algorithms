/// https://leetcode.com/problems/angles-of-a-triangle/description/


class Solution {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);
        if (sides[0]+sides[1] <= sides[2]) return new double[]{};

        double[] ans = new double[3];
        double a = sides[0], b=sides[1], c=sides[2];
        
        
        ans[0] = Math.toDegrees(Math.acos((a*a + b*b - c*c) / (2.0f*a*b)));
        ans[1] = Math.toDegrees(Math.acos((a*a + c*c - b*b) / (2.0f*a*c)));
        ans[2] = Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2.0f*b*c)));

        Arrays.sort(ans);
        return ans;
    }
}