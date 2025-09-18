/// https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/description/

class Solution {
    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        int ans = 0, start = 0;
        int unique = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && word.charAt(i) < word.charAt(i - 1)) {
                start = i;
                unique = 0;
            }

            if (i == 0 || word.charAt(i) != word.charAt(i - 1)) {
                unique++;
            }

            if (unique == 5) {
                ans = Math.max(ans, i - start + 1);
            }
        }

        return ans;
    }
}