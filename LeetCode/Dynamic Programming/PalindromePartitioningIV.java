/// https://leetcode.com/problems/palindrome-partitioning-iv/description/

class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];

        // palindrome pre-processing
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                pal[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || pal[i + 1][j - 1]);
            }
        }


        for (int i = 1; i <= n - 2; i++) {
            if (!pal[0][i - 1]) continue;

            for (int j = i + 1; j <= n - 1; j++) {
                if (pal[i][j - 1] && pal[j][n - 1])
                    return true;
            }
        }

        return false;
    }
}