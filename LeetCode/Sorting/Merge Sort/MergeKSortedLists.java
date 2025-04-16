https://leetcode.com/problems/merge-k-sorted-lists/description/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int numOfLists = lists.length ;
        if (numOfLists == 0) return null;
        for (int i = 1 ; i < numOfLists ; i++){
            lists[i] = mergee(lists[i],lists[i-1]);
        }

        return lists[numOfLists -1 ];

    }
    public ListNode mergee (ListNode left ,ListNode right){
        ListNode temp = new ListNode(-1);
        ListNode curr = temp ;
        while (left != null && right != null){
            if(left.val < right.val ){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next ;
        }
        while(left != null){
            curr.next = left;
            left = left.next;
            curr = curr.next ;
        }
        while(right != null){
            curr.next = right;
            right = right.next;
            curr = curr.next ;
        }
        return temp.next ;
    }
}
