// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head, prev = head;
        while (curr != null){
            size++;
            curr = curr.next; 
        }
        curr = head;
        if (size-n == 0) {return curr.next;}
        for (int i = 1; i <= size-n; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
    }
}
