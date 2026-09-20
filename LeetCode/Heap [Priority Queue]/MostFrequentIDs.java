///  https://leetcode.com/problems/most-frequent-ids/description/

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Integer, Long> mp = new HashMap<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(b[1],a[1]));
        
        long[] ans = new long[nums.length];

        for(int i=0; i<nums.length; ++i){
            Long val = mp.getOrDefault(nums[i], 0L) + freq[i];
            mp.put(nums[i], val);

            pq.add(new long[]{nums[i], val});

            while(!pq.isEmpty() && mp.get((int)pq.peek()[0]) != pq.peek()[1]) pq.poll();

            ans[i] = pq.peek()[1];
        }

        return ans;
    }
}