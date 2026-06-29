// https://leetcode.com/problems/next-greater-node-in-linked-list/



class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nums.add(curr.val);
            curr = curr.next;
        }
        
        int n = nums.size();
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); 
        
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums.get(i) > nums.get(stack.peek())) {
                int indexToResolve = stack.pop();
                result[indexToResolve] = nums.get(i);
            }
            stack.push(i);
        }
        
        return result;
    }
}