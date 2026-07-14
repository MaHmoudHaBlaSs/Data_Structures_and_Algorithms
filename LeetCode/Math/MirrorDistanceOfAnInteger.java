// https://leetcode.com/problems/mirror-distance-of-an-integer/description/

class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString()));
    }
}