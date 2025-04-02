// https://leetcode.com/problems/partition-list

// Optimal Runtime.
// T: O(n)          S: O(n)
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(), larger = new ListNode();
        ListNode temp = head, tless = less, tlarger = larger;
        while (temp != null){
            if (temp.val >= x){
                tlarger.next = new ListNode(temp.val);
                tlarger = tlarger.next;
            }
            else{
                tless.next = new ListNode(temp.val);
                tless = tless.next;
            }
            temp = temp.next;
        }

        tless.next = larger.next;
        return less.next;
    }
}