// https://leetcode.com/problems/reverse-nodes-in-k-group

class Solution {
    boolean validSubList = false;


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode retHead = head;
        for(int i = 1; i < k; i++){
            retHead = retHead.next;
        }

        ListNode connection = null;
        while (temp != null){
            ListNode start = temp;

            if(connection != null) connection.next = start;
            for(int i = 1; i <= k; i++){
                if (temp != null)
                    temp = temp.next;
                else{
                    return retHead;
                }
            }
            reverse(null, start, connection, 1, k);
            connection = start;
        }
        return retHead;
    }

    public void reverse(ListNode prev, ListNode curr, ListNode connection , int step, int k){
        if (curr == null){
            validSubList = false;
            return;
        }

        if (step == k) { // first call step = 1
            validSubList = true;
            //newHead = curr;

            if (connection != null) connection.next = curr;
            curr.next = prev;
            return;
        }

        reverse(curr, curr.next, connection, step+1, k);
        
        if (validSubList)
            curr.next = prev;
    }
}