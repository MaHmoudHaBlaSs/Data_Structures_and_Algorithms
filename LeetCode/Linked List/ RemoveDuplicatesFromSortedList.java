// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/


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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy; 

        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                curr.next = new ListNode(head.val);
                curr = curr.next; 
            }
            head = head.next;
        }
        return dummy.next;
    }
}