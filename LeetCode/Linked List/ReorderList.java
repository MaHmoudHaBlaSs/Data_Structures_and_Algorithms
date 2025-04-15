// https://leetcode.com/problems/reorder-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode temp = new ListNode(-1);
        ListNode curr = temp;
        Stack<ListNode> stack = new Stack<>();
        ListNode prev = head;

        
        while (prev != null) {
            stack.push(prev);
            prev = prev.next;
        }

        ListNode front = head;
        int size = stack.size();
        int counter = 0;

        while (counter < size / 2) {
          
            curr.next = front;
            curr = curr.next;
            front = front.next;

            
            curr.next = stack.pop();
            curr = curr.next;

            counter++;
        }

        // If there's a middle node (odd number of nodes)
        if (size % 2 == 1) {
            curr.next = front;
            curr = curr.next;
        }

        
        curr.next = null;
        
        head = temp.next;
    }
}
