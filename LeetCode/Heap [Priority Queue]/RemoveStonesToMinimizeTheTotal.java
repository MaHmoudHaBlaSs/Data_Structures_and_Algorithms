// https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/


class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int totalStones =0;
        for (int pile : piles) {
            pq.offer(pile);
            totalStones+=pile;
        }

        for (int i = 0; i < k; i++) {
            int largestPile = pq.poll();
            int reducedPile = largestPile - (largestPile / 2);
            pq.offer(reducedPile);
            totalStones-=(largestPile / 2);
        }
        
        return totalStones;
    }
}