///  https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new  PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        pq.addAll(map.entrySet());

        while(k-- > 0){
            var top = pq.peek();
            if(top.getValue() > 1) top.setValue(top.getValue() - 1);
            else pq.poll();
        }
        
        return pq.size();
    }
}

