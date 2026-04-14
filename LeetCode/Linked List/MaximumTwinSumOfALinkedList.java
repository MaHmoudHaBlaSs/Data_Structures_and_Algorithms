// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/


class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            list.add(curr.val );
            curr = curr.next;
        }
        int max = Integer.MIN_VALUE , n = list.size();
        for(int i = 0 ; i < n / 2 ; i++){
            int currSum = list.get(i) + list.get(n-1-i) ;
            max = Math.max(currSum,max);
        }
        return max;
    }
}