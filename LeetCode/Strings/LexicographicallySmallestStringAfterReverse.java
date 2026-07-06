///  https://leetcode.com/problems/lexicographically-smallest-string-after-reverse/description/

class Solution {
    public String lexSmallest(String s) {
        String ans = s;
        int n = s.length();

        for (int k = 1; k <= n; k++) {
            String left = s.substring(0, k);
            String right = s.substring(k);

            String candidate1 = new StringBuilder(left).reverse().append(right).toString();
            String candidate2 = left + new StringBuilder(right).reverse().toString();

            if (candidate1.compareTo(ans) < 0) ans = candidate1;
            if (candidate2.compareTo(ans) < 0) ans = candidate2;
        }

        return ans;
    }
}