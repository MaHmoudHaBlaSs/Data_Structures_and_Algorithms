///  https://leetcode.com/problems/arranging-coins/description/

class Solution {
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(1+8L*n)-1)/2);
    }
}