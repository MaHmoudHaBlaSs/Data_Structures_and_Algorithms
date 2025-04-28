// https://leetcode.com/problems/gas-station/description/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }

        for (int y : diff) {
            sum += y;
        }

        if (sum < 0) return -1;

        int tank = 0, start = 0;
        for (int i = 0; i < diff.length; i++) {
            tank += diff[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}
