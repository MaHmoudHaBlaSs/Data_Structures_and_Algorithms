// https://leetcode.com/problems/permutation-in-string/description/

// Optimal.
// T: O(n)        S: O(1)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Maps
        int[] freq = new int[26];
        int[] window = new int[26];
        
        for (char ch: s1.toCharArray())
            freq[ch-'a']++;

        int left = 0;
        for(int right = 0; right < s2.length(); right++){
            window[s2.charAt(right)-'a']++; // Expand Window

            if (right-left+1 > s1.length()){
                window[s2.charAt(left)-'a']--; // Shrink Window
                left++;
            }
            if (Arrays.equals(freq, window)) return true;
        }
        return false;
    }
}