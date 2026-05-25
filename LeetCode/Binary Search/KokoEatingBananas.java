// https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1, right = piles[piles.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid; // Try a smaller speed
            } else {
                left = mid + 1; // Need a larger speed
            }
        }
        return left;
    }
    public boolean canFinish(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + speed - 1) / speed; // Equivalent to ceil(pile/speed)
        }
        return hoursNeeded <= h;
    }
}