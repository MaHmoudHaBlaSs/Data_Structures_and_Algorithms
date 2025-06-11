// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/?envType=problem-list-v2&envId=greedy


class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int  sum= 0;
        for (int i = piles.length - 2 ;  i > (piles.length / 3) -1 ; i-=2) {
            sum += piles[i];
        }
        return sum ;
    }
}