///  https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/

class Solution {
    public int minOperations(int[] nums, long k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int n : nums) 
            pq.add((long)n);

        int count = 0;
        while(pq.size() >= 2 && pq.peek() < k){
            long x = pq.poll(), y = pq.poll();

            pq.add(Math.min(x, y) * 2 + Math.max(x, y));
            count++;
        }
        
        return count;
    }
}