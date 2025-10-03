/// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/


import java.math.BigDecimal;
import java.math.RoundingMode;
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int ans = -1;
        int left= 1, right=10_000_002;

        while(left <= right){
            int mid = (left+right)/2;
            if(canReachInTime(dist,mid,hour)){
                ans = mid; 
                right = mid-1;
            }
            else left = mid+1;
        }

        return ans;
    }

    private boolean canReachInTime(int[] dist, int speed, double hour){
        for(int i=0; i<dist.length-1 && hour > 0; i++){
            hour -= Math.ceilDiv(dist[i] , speed);
        } 
        
        hour -= (double)dist[dist.length-1] / speed; 
        BigDecimal bd = BigDecimal.valueOf(hour);
        bd = bd.setScale(9, RoundingMode.HALF_UP);
        return bd.doubleValue() >= 0.0;
    } 
}
