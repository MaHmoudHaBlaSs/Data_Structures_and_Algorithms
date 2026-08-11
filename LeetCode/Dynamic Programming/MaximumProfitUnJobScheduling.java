/// https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/


class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] arr = new int[n][3];

        for(int i=0; i<n; ++i){
            arr[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(arr , (a,b) -> a[1]-b[1]);

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0,0);

        for(int i=0; i<n; ++i){
            int maxProfit = dp.lastEntry().getValue();
            maxProfit = Integer.max(maxProfit, dp.floorEntry(arr[i][0]).getValue() + arr[i][2]);

            dp.put(arr[i][1], maxProfit);
        }

        return dp.lastEntry().getValue();
    }
}