// https://leetcode.com/problems/time-needed-to-buy-tickets/description/



class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
    int timer = 0;
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < tickets.length; i++) {
        queue.add(i);
    }
    while(tickets[k] > 0 ){
        if(tickets[queue.peek()] > 0) {
            tickets[queue.peek()]--;
            queue.add(queue.remove());
            timer++;
        }else{
            queue.remove();
        }
        
    }
    return timer;
}
}