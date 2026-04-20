///  https://leetcode.com/problems/design-event-manager/description/


class EventManager {
    private PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
        if(a[1] != b[1]) return b[1]-a[1]; 
        return a[0]-b[0]; 
    });
    private HashMap<Integer, Integer> lastPriority = new HashMap<>(); 

    public EventManager(int[][] events) {
        for(int[] event : events){
            pq.offer(event); 
            lastPriority.put(event[0], event[1]); 
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        pq.offer(new int[] {eventId, newPriority}); 
        lastPriority.put(eventId, newPriority); 
    }
    
    public int pollHighest() {
        while(!pq.isEmpty()){
            int[] ev = pq.peek(); 
            if(lastPriority.get(ev[0]) == ev[1]) break; 
            pq.poll();
        } 

        if(pq.isEmpty()) return -1;

        int[] event = pq.poll();
        lastPriority.put(event[0], -1);
        return event[0];  
    }
}
