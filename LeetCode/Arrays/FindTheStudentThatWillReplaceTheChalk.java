/// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int n : chalk) sum += n;

        int turns = 0;

        if(sum < k) {
            turns = k/(int)sum;
            k -= sum * turns;
        }

        for (int i = 0; i < chalk.length; i++) {
            if(chalk[i] > k) return i;

            k -= chalk[i];
        }

        return 0;
    }
}