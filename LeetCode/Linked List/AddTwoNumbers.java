// https://leetcode.com/problems/add-two-numbers/description/

class Solution {
    // Search for Base 10 Addition process Like (Binary Addition)
    // T: O(n*m)       S: O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int v1 = (l1 != null)? l1.val: 0;
            int v2 = (l2 != null)? l2.val: 0;
            int val = v1+v2+carry; // max == 19 [9+9+1]
            if(val >= 10){
                carry = 1;
                val -= 10;
            }
            else carry = 0;
            temp.next = new ListNode(val);
            temp = temp.next;
            l1 = (l1 != null)?l1.next:null;
            l2 = (l2 != null)?l2.next: null;
        }
        return head.next;
    }
}
