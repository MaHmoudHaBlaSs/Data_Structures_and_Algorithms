///  https://leetcode.com/problems/maximum-points-inside-the-square/description/

class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        // find largest valid square then count the points
        
        int l=0, r= 1_000_000_000;
        int ans = 0;
        
        while(l <= r){
            int mid = (l+r) >> 1;
            
            int c = maxPoints(points, mid, s);
            if(c == -1){
                r = mid-1;
            }else{
                ans = Math.max(ans, c);
                l = mid+1;
            }
        }
        
        return ans;
    }
    
    private int maxPoints(int[][] points, int len, String s){
        boolean[] taken = new boolean[26];
        
        int c = 0;

        for (int i = 0; i < points.length; i++) {
            int x = Math.abs(points[i][0]), y = Math.abs(points[i][1]);
            
            if(x <= len && y <= len){
                int tag = s.charAt(i)-'a';
                
                if(taken[tag]) return -1;
                
                taken[tag] = true;
                c++;
            }
        }
        
        return c;
    }
}