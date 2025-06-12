// https://leetcode.com/problems/number-of-recent-calls

class RecentCounter {
    Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }
    
    // T: O(n)
    public int ping(int t) {
        requests.add(t);
        int lower = t-3000;
        
        while (requests.peek() < lower)
            requests.poll();

        return requests.size();
    }
}