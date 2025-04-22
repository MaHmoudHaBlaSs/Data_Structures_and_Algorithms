// https://leetcode.com/problems/kth-largest-element-in-a-stream/description

// Space complexity can be enhanced if we reuse nums array as heap.
class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    // O(nLog(n))
    public KthLargest(int k, int[] nums) {
        minHeap =  new PriorityQueue<>();
        this.k = k;

        for (int num: nums)
            minHeap.add(num);

        while (minHeap.size() > k)
            minHeap.poll();
    }

    // O(Log(n))
    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}