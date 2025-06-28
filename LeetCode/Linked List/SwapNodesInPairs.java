// https://leetcode.com/problems/swap-nodes-in-pairs

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = new ListNode(0);
        curr.next = head;
        ListNode temp = curr;

        while (temp.next != null && temp.next.next != null){
            ListNode first = temp.next, second = temp.next.next;

            temp.next = second;
            first.next = second.next;
            second.next = first;
            
            temp = first;
        }
        return curr.next;
    }
}