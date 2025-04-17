https://leetcode.com/problems/sort-list/description/

// I use Mereg sort which is need to find the Mid of the LinkeList so i Use  Floyd's Slow And Fast Pointers
// The Time Complexity is  { N Log(N) } 


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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode midPrev = findMiddle(head);
        ListNode mid = midPrev.next;
        midPrev.next = null;

        ListNode left = sortList(head); // Divide
        ListNode right = sortList(mid); // Divide

        return merge(left, right); // Conquer


    }
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // We use previous pointer to cut the list at middle or middle-1 index
        // The crucial reason to use it instead of only using slow pointer and cut the list at middle or middle+1 index 
        // is that slow pointer selection will cause infinite recursion with list of length 2
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev; 
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode temp = new ListNode(-1); // علشان احافظ ع البدايه
        ListNode curr = temp; // علشان اعرف اتحرك
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) {
            curr.next = left;
        }else {
            curr.next = right;
        }
        return temp.next;
    }
}
