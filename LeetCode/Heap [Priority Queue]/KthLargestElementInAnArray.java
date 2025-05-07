// https://leetcode.com/problems/kth-largest-element-in-an-array/

// This problem can be solved using QuickSelect but this has worst case of O(n^2)
// and best of O(n) so it depends on the natrue of the input which is risky.
class Solution {
    // T: O(n)              S: O(n)
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> customComp = (a, b) -> Integer.compare(b, a);
        Queue<Integer> maxHeap = new PriorityQueue<>(customComp);

        for (int num: nums)
            maxHeap.add(num);
        
        while(!maxHeap.isEmpty()){
            int polled = maxHeap.poll();
            k--;
            if (k == 0) return polled;
        }
        return -1;
    }
}