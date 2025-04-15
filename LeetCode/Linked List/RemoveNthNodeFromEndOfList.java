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


// another sol using Floyd's Slow And Fast Pointers which is take better time complexity 

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head , fast = head  ;

        for(int i = 0 ; i < n ; i++ ){
            fast = fast.next ;
        }
        
        if (fast == null) {
            return head.next;
        }

        while(fast.next != null ){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head ;
    }
}
