///  https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/description/

class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum=0, rounds = 0;
        int n = milestones.length, max = 0;

        for (int milestone : milestones) {
            if (milestone > max) max = milestone;

            sum += milestone;
        }

        long others = sum - max;

        if(others >= max-1) return sum;

        return sum - (max - others-1);
    }
}
