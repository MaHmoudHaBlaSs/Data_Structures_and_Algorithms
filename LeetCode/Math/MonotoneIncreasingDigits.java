// https://leetcode.com/problems/monotone-increasing-digits/description/

class Solution {
    public int monotoneIncreasingDigits(int n) {
        String numStr = Integer.toString(n);
        char[] digits = numStr.toCharArray();
        int pt = digits.length;

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                pt = i;
                digits[i - 1]--;
            }
        }

        for (int i = pt; i < digits.length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(new String(digits));
    }
}