// https://leetcode.com/problems/rotate-list/

// Optimal Runtime.
// T: O(n)         S: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode lastNode = head, curr = head;
        int len = 1;

        while (lastNode.next != null){
            len++;
            lastNode = lastNode.next;
        }
        k %= len;

        for(int i = 1; i < len-k; i++)
            curr = curr.next;
        
        lastNode.next = head;
        head = curr.next;
        curr.next = null;
        
        return head;
    }
}