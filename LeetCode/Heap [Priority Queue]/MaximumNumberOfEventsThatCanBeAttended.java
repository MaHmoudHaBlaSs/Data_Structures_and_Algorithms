/// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        int ans=0, d=events[0][0], idx=0, n=events.length; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for(int i=0; i<n; ++i){
            if(idx<n && pq.isEmpty() && d < events[idx][0]) 
                d=events[idx][0]; 
            
            while(idx<n && events[idx][0] <= d) pq.offer(events[idx++]);

            while(!pq.isEmpty() && d > pq.peek()[1]) pq.poll();

            if(!pq.isEmpty()) {
                int[] event = pq.poll();

                ++ans; 
                d=Math.max(d+1,event[0]+1);
            }
        }

        return ans;
    }
}