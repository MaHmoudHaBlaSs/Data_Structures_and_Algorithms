///  https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';

            if (first[curr] == - 1) first[curr] = i;
            
            last[curr] = i;
        }
        
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;
            
            Set<Character> set = new HashSet();
            for (int j = first[i] + 1; j < last[i]; j++) {
                set.add(s.charAt(j));
            }
            
            ans += set.size();
        }
        
        return ans;
    }
}