///     https://leetcode.com/problems/odd-even-linked-list/description/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) 
            return head;

        ListNode lastOdd = head, lastEven = head.next;
        while(lastEven != null && lastEven.next != null){
            ListNode tmp = lastEven.next;
            lastEven.next = lastEven.next.next;
            lastEven = lastEven.next; 

            tmp.next = lastOdd.next; 
            lastOdd.next = tmp; 
            lastOdd = tmp;            
        }

        return head;
    }
}