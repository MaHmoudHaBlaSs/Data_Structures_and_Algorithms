// https://leetcode.com/problems/last-stone-weight

// Optimal.
// T: O(n)          S: O(n)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer stone: stones)
            maxHeap.add(stone);

        int stone1 = 0, stone2 = 0;
        while(maxHeap.size() > 1){
            stone1 = maxHeap.poll();
            stone2 = maxHeap.poll();
            
            if (Math.abs(stone1 - stone2) > 0)
                maxHeap.add(Math.abs(stone1 - stone2));
        }
        return (maxHeap.size() == 0)?Math.abs(stone1 - stone2): maxHeap.poll();
    }
}