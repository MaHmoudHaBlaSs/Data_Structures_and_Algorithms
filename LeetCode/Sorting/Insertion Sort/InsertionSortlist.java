
// Problem_Link = https://leetcode.com/problems/insertion-sort-list/?envType=problem-list-v2&envId=sorting

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
    public ListNode insertionSortList(ListNode head) {
            ListNode sortedList = head;
            ListNode currentNode = head.next;

            sortedList.next = null;  // علشان اخد اول عنصر بس 

            while (currentNode != null) {
                ListNode next = currentNode.next;
                ListNode prev = sortedList; // علشان اسهل اني اعدي ع عناصر الليست اللي مترتبه
                
            

                if (currentNode.val < sortedList.val) {
                    currentNode.next = sortedList;
                    sortedList = currentNode;
                } else {

                    while (prev.next != null && prev.next.val < currentNode.val) {
                        prev = prev.next;
                    }

                    currentNode.next = prev.next;
                    prev.next = currentNode;
                }

                currentNode = next; 
            }

            return sortedList;
        }
}
