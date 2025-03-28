https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/?envType=problem-list-v2&envId=sliding-window


class Solution {
    public static int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0; 

        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
            if (a != b && b != c && a != c) { 
                count++;
            }
        }
        return count;
    }
}
