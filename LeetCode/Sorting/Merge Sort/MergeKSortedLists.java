// https://leetcode.com/problems/merge-k-sorted-lists/description/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int numOfLists = lists.length ;
        if (numOfLists == 0) return null;

        for (int i = 1 ; i < numOfLists ; i++){
            lists[i] = merge(lists[i],lists[i-1]);
        }

        return lists[numOfLists -1 ];

    }
    
    // Min Heap Solution [Better]
    // T: O(nLog(k))             S: O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode sorted = new ListNode();
        ListNode temp = sorted;

        for (ListNode node: lists)
            if (node != null) minHeap.add(node);

        while (!minHeap.isEmpty()){
            ListNode polled = minHeap.poll();
            temp.next = polled;
            temp = temp.next;
            
            if (polled.next != null) minHeap.add(polled.next);
        }
        return sorted.next;
    }

    // T: O(n*k) >> k = lists, n = list.length         S: O(1)
    public ListNode merge (ListNode left ,ListNode right){
        ListNode temp = new ListNode(-1);
        ListNode curr = temp ;
        
        while (left != null && right != null){
            if(left.val < right.val ){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next ;
        }
        if (left != null) curr.next = left;
        if (right != null) curr.next = right;

        return temp.next ;
    }
}
