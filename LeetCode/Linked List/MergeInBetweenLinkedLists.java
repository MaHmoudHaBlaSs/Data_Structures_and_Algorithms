///  https://leetcode.com/problems/merge-in-between-linked-lists/description/

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1, prevA = null, afterB = null, list2Tail = list2;
        int i=0; 
        while(curr.next != null){
            if(i == a-1) prevA = curr;
            if(i == b) afterB = curr.next;

            i++;
            curr = curr.next;
        } 

        while(list2Tail.next != null) list2Tail = list2Tail.next;

        prevA.next = list2;
        list2Tail.next = afterB;
        return list1;
    }
}