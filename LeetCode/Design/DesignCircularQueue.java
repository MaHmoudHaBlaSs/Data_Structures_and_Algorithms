// https://leetcode.com/problems/design-circular-queue/


// It is just a linkedlist with a fixed size 

class MyCircularQueue {
    
   
    private LinkedList<Integer> queue ;
    int size;
    public MyCircularQueue(int k) {
        queue = new LinkedList<>();
        size = k;
    }

    public boolean enQueue(int value) {
        if (queue.size() >= size) return false;
        queue.add(value);
        return true;
    }

    public boolean deQueue() {
        if (queue.isEmpty()) return false;
        queue.remove();
        return true;
    }

    public int Front() {
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public int Rear() {
        if (queue.isEmpty()) return -1;
        return queue.get(queue.size() - 1);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() == size;
    }

}


