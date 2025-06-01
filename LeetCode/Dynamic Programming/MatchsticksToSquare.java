/// https://leetcode.com/problems/matchsticks-to-square/description/

class Solution {
    private int[] sticks;
    private int sideLength;
    private int fullMask;
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int num : matchsticks) total += num;
        if (total % 4 != 0) return false;

        sideLength = total / 4;
        sticks = matchsticks;
        fullMask = (1 << sticks.length) - 1;

        return can(0, 0, 0);
    }

    private boolean can(int usedMask, int currSum, int sidesCompleted) {
        if (sidesCompleted == 3) return true; // only 3 needed
        String key = usedMask + "," + currSum + "," + sidesCompleted;
        if (memo.containsKey(key)) return memo.get(key);

        for (int i = 0; i < sticks.length; i++) {
            if ((usedMask & (1 << i)) != 0) continue; // already used
            if (currSum + sticks[i] > sideLength) continue; //will break the length

            int newSum = currSum + sticks[i];
            int newMask = usedMask | (1 << i);
            int newSides = sidesCompleted + (newSum == sideLength ? 1 : 0);

            if (can(newMask, newSum % sideLength, newSides)) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}
