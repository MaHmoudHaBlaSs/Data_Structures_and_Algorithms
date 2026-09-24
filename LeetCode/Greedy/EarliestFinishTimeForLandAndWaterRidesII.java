// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landFirst = getMinFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        int waterFirst = getMinFinishTime(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(landFirst, waterFirst);
    }
    private int getMinFinishTime(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int minEnd1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            minEnd1 = Math.min(minEnd1, start1[i] + duration1[i]);
        }

        int minEnd2 = Integer.MAX_VALUE;
        for (int j = 0; j < start2.length; j++) {
            int startTime = Math.max(start2[j], minEnd1);
            minEnd2 = Math.min(minEnd2, startTime + duration2[j]);
        }

        return minEnd2;
    }
}