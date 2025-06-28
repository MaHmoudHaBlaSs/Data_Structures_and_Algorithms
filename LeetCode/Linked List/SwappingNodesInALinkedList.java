// https://leetcode.com/problems/swapping-nodes-in-a-linked-list

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;

        while(temp != null){
            n++;
            temp = temp.next;
        }
        
        temp = head;
        ListNode node1 = null, node2 = null;
        for(int i = 1; i <= n; i++){
            if (k-i == 0)
                node1 = temp;
            if (n-i == k-1)
                node2 = temp;

            temp = temp.next;
        }
        swap(node1, node2);
        return head;
    }

    public void swap(ListNode node1, ListNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}