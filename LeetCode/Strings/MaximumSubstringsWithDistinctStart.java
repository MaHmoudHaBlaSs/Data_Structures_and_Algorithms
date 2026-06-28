///  https://leetcode.com/problems/maximum-substrings-with-distinct-start/description/

class Solution {
    public int maxDistinct(String s) {
        int[] freq = new int[26]; 
        
        for(int i=0; i<s.length(); ++i){
            freq[s.charAt(i) - 'a']++;
        }

        int ans = 0;
        for(int i=0; i<26; ++i){
            if(freq[i] > 0) ans++;
        }

        return ans;
    }
}