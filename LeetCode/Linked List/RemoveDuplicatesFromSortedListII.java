//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/




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

        Map<Integer,Integer> nums = new HashMap<>();

        ListNode current = head;
        while (current != null) {
            if(nums.containsKey(current.val)){
                nums.put(current.val, nums.get(current.val)+1);
            }else{
                nums.put(current.val , 1);
            }

            current = current.next;
        }



        ListNode res = null;
        ListNode curr = null;

        for (Integer n : nums.keySet().stream().sorted().toList()) {
            if(nums.get(n) == 1) {
                if (res == null) {

                    res = new ListNode(n);
                    curr = res;

                } else {
                    curr.next = new ListNode(n);
                    curr = curr.next;
                }
            }
        }

        return res;


    }
}