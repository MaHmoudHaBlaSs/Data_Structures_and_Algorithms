// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/


class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if ((bitA | bitB) != bitC) {
                if (bitC == 0) {
                    flips += bitA + bitB; // Flip both if they are 1
                } else {
                    flips += 1; // Flip one of them to 1
                }
            }
        }
        return flips;
    }
}