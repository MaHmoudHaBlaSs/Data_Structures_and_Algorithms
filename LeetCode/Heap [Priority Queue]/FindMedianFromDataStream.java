// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {
    PriorityQueue<Integer> minHeap; // Right Half
    PriorityQueue<Integer> maxHeap; // Left Half

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        // Max Heap size must be equal to min or greater by 1
        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {

        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek()*1.0) / 2;
    }
}