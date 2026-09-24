// https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/

class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxVowelFreq = 0 , maxConsonantFreq = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            if ("aeiou".indexOf(c) != -1) {
                maxVowelFreq = Math.max(maxVowelFreq, freq[i]);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, freq[i]);
            }
        }
        return maxVowelFreq + maxConsonantFreq;
    }
}