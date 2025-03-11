https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150

public boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;
        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;  
            }
            tPointer++;  
        }
        return sPointer == s.length();  
    }
