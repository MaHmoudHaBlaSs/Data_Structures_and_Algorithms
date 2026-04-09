///  https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/description/


class Solution {
    public int minOperations(int[] nums) {
        int ans = 0, n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>(); 

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            
            while(!st.isEmpty() && st.peekLast() > curr){
                st.removeLast();
            }
            
            if (curr == 0) continue;
            if (st.isEmpty() || st.peekLast() < curr) {
                ans++;
                st.add(curr);
            }            
        }

 
        return ans;
    }
}