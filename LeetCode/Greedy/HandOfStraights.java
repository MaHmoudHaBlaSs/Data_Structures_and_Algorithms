// https://leetcode.com/problems/hand-of-straights/description/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        
        for (int num : hand) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        while (!freqMap.isEmpty()) {
            int start = freqMap.firstKey();  

            for (int i = start; i < start + groupSize; i++) {
                if (!freqMap.containsKey(i)) return false;

                freqMap.put(i, freqMap.get(i) - 1);
                if (freqMap.get(i) == 0) {
                    freqMap.remove(i);
                }
            }
        }

        return true;
    }
}
