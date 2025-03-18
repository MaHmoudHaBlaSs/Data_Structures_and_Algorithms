// https://leetcode.com/problems/linked-list-cycle-ii/description/

// Optimal Solution
// T: O(n)      S: O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                slow = head;
                while (slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// The problem consists of two halfs first one is to find the node that slow pointer meets fast pointer at (after increasing both not only one of them)
// then we already know that there's a cycle 
// the second half is to know the starting node of the cycle, By observation we can tell that the distance from the intersection node to
// the first node in the cycle is equal to the distance from head node to that first node in the cycle, so we will set slow or fast pointer to the head
// and increasing both pointers by the same step and the node they meet at will be the starting node.