///  https://leetcode.com/problems/validate-stack-sequences/


class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0; 

        for(int num : pushed){
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop(); 
                j++;
            }

            st.push(num); 
        }

        while(!st.isEmpty() && st.peek() == popped[j]){
            st.pop(); 
            j++;
        }

        return st.isEmpty();
    }
}