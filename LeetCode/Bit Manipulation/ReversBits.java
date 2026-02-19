// https://leetcode.com/problems/reverse-bits/description/

class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }
        while(sb.length()< 32){
            sb.append(0);
        }
        return Integer.parseInt(sb.toString(),2);
    }
}