// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/


// T: O(n)               S: O(n)
class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> included = new HashSet<>();
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++)
            lastIndex[s.charAt(i)-'a'] = i;


        for (int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if (included.contains(currChar)) continue;

            while (!stack.isEmpty() && currChar < stack.peek() && lastIndex[stack.peek()-'a'] > i){
                included.remove(stack.pop());
            }

            included.add(currChar);
            stack.push(currChar);
        }
        
        StringBuilder  result = new StringBuilder();
        for (char ch: stack)
            result.append(ch);
        return result.toString();
    }
}