///   https://leetcode.com/problems/k-closest-points-to-origin/description/

//T: O(n.log(n))        S: O(k)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (point1, point2) -> { 
            return (point1[0]*point1[0] + point1[1]*point1[1]) - (point2[0]*point2[0] + point2[1]*point2[1]);
        });

        int[][] ans = new int[k][2]; 
        for(int i=0;i<k;i++)
            ans[i] = points[i]; 

        return ans; 
    }
}