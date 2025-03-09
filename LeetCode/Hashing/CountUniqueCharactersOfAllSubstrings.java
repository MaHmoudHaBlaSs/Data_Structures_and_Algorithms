/// https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/description/

/*
Think about calculating the contribution of each character to the final answer. 
For each position of a character in the string:
    Consider how many substrings contain this character exactly once

For each character position, you need to determine:
    How many substrings start before or at this position
    How many substrings end at or after this position

Multiply these distances to get the number of substrings where this character appears exactly once.
*/

class Solution {
    public int uniqueLetterString(String s) {
        // O(n log n)
        HashMap<Character, TreeSet<Integer>> mp = new HashMap<>();
        int len = s.length();

        for(int i=0; i<len;i++){
            char ch = s.charAt(i);

            if(!mp.containsKey(ch)) mp.put(ch, new TreeSet<>());

            mp.get(ch).add(i);
        }

        int result = 0;
        for(int i = 0; i<len; i++){
            char ch = s.charAt(i);
            
            Integer lastOccurrenceBefore = mp.get(ch).lower(i);
            int before = i - (lastOccurrenceBefore == null ? -1 : lastOccurrenceBefore);

            Integer firstOccurrenceAfter = mp.get(ch).higher(i);
            int after = (firstOccurrenceAfter == null ? len : firstOccurrenceAfter) - i;
            
            result += before * after; 
        }


        return result;
    }
}