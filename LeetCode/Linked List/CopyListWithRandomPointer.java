// https://leetcode.com/problems/copy-list-with-random-pointer/description/

// Optimal
class Solution {
    // T: O(n)     S: O(n)
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node nHead = new Node(0);
        Node temp = head, ntemp = nHead;

        while (temp != null){
            ntemp.next = new Node(temp.val);
            map.put(temp, ntemp.next);
            
            temp = temp.next; 
            ntemp = ntemp.next;
        }
        temp = head; ntemp = nHead.next;
        while (temp != null){
            if (temp.random != null) ntemp.random = map.get(temp.random);
            temp = temp.next; 
            ntemp = ntemp.next;
        }
        return nHead.next;
    }
}
