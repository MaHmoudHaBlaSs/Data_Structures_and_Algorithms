// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/?envType=daily-question&envId=2025-06-10

class Solution {
    public int maxDifference(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int maxDiff = Integer.MIN_VALUE;
        boolean found = false;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                for (int j = 0; j < 26; j++) {
                    if (freq[j] % 2 == 0 && freq[j] > 0) { 
                        int diff = freq[i] - freq[j];
                        maxDiff = Math.max(maxDiff, diff);
                        found = true;
                    }
                }
            }
        }


        return found ? maxDiff : 0;
    }
}