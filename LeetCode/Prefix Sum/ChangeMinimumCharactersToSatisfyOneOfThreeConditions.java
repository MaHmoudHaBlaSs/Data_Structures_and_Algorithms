/// https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/description/

class Solution {
    public int minCharacters(String a, String b) {
        int[] freq1 = new int[26], freq2 = new int[26];
        int[] prefix1 = new int[26], prefix2 = new int[26];
        int n1 = a.length(), n2 = b.length(), ans = n1+n2;
        
        for(char ch : a.toCharArray()) freq1[ch-'a']++;
        for(char ch : b.toCharArray()) freq2[ch-'a']++;
        
        prefix1[0] = freq1[0]; prefix2[0] = freq2[0];
        ans = n2 - freq2[0] +  n1 - freq1[0];
        
        for (int i = 1; i < 26; i++) {
            prefix1[i] = freq1[i]+  prefix1[i-1];    
            prefix2[i] = freq2[i]+  prefix2[i-1];    
        
            ans = Math.min(ans, n1 - prefix1[i-1] + prefix2[i-1]);
            ans = Math.min(ans, n2 - prefix2[i-1] + prefix1[i-1]);
            ans = Math.min(ans, n2 - freq2[i] +  n1 - freq1[i]);
        }
        
        return ans;
    }

}