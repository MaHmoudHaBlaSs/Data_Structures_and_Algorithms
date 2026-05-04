/// https://leetcode.com/problems/minimum-bitwise-or-from-grid/description/


class Solution {
    public int minimumOR(int[][] grid) {
        boolean[] canBeExcluded = new boolean[31];
        Arrays.fill(canBeExcluded, true);

        int forbiddenMask = 0;

        for (int i = 30; i >= 0; --i) {
            for (int[] row : grid) {
                boolean validRow = false;

                for (int num : row) {
                    if ((num & forbiddenMask) == 0 && (num & (1 << i)) == 0) {
                        validRow = true;
                        break;
                    }
                }

                if (!validRow) {
                    canBeExcluded[i] = false;
                    break;
                }
            }

            if (canBeExcluded[i]) {
                forbiddenMask |= (1 << i);
            }
        }

        int ans = 0;
        for (int i = 0; i <= 30; i++) {
            if (!canBeExcluded[i]) {
                ans |= (1 << i);
            }
        }

        return ans;
    }
}