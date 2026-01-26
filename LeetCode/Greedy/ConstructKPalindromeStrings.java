/// https://leetcode.com/problems/construct-k-palindrome-strings/description/

class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(k > n) return false;
        if(k == n) return true;

        int[] freq = new int[26];
        for(int i=0; i<n; ++i){
            freq[s.charAt(i)-'a']++;
        }

        int odd = 0;
        for(int num : freq) {
            if((num & 1) == 1) ++odd; 
        }

        return odd <= k;
    }
}