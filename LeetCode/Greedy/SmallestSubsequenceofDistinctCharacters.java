// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/


// T: O(n)               S: O(n)
class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurence = new int[26];
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++)
            lastOccurence[s.charAt(i) - 'a'] = i;
        
        for (int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            
            if (!set.contains(currChar)){
                while (!stack.isEmpty() && currChar < stack.peek() && lastOccurence[stack.peek() - 'a'] > i){
                    set.remove(stack.pop());
                    builder.deleteCharAt(builder.length()-1);
                }
                stack.push(currChar);
                set.add(currChar);
                builder.append(currChar);
            }
        }

        return builder.toString();
    }
}