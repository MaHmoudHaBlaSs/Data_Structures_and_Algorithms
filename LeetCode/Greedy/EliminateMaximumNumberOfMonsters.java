///  https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/


class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] time = new double[dist.length];
        for(int i=0; i<dist.length; i++){
            time[i] = 1.0 * dist[i] / speed[i] ;
        }

        Arrays.sort(time);
        int ans = 0, currTime = 0; 
        for(int i=0; i<time.length; i++){
            if(currTime >= time[i]) break;

            currTime++;
            ans++;
        }

        return ans; 
    }
}