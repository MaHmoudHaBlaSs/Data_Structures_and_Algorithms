// https://leetcode.com/problems/linked-list-cycle/description/

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int counter = 0;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
            slow = slow.next;
        } 
        return false;
    }
}
