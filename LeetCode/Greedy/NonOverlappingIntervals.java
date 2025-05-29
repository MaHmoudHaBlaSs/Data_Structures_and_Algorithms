/// https://leetcode.com/problems/non-overlapping-intervals/description/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int ans = 0, lastEnd = intervals[0][0] - 1;
        
        for(int[] interval : intervals){
            if(interval[0] < lastEnd){
                ans++;
                if(lastEnd < interval[1]) continue; //the current interval is removed else the previous is removed
            }
            
            lastEnd = interval[1];
        }
        
        return ans;
    }
}