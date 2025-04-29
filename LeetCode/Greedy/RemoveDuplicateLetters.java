// https://leetcode.com/problems/remove-duplicate-letters/


class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int [] freq = new int[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder st = new StringBuilder();
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for(char c : s.toCharArray()){
            --freq[c - 'a'];
            if(!visited[c-'a']){
                visited[c-'a'] = true;
                while(!stack.isEmpty() && stack.peek().compareTo(c) > 0 && freq[stack.peek() - 'a'] > 0 ){
                    visited[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            st.append(stack.pop());
        }
        return st.reverse().toString();
    }

}
