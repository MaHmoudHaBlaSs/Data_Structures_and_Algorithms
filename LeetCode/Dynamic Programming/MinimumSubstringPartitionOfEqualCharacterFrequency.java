///  https://leetcode.com/problems/minimum-substring-partition-of-equal-character-frequency/description/

class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1); 

        return solve(0, s, memo);
    }

    private int solve(int i, String s,int[] memo) {
        int n = s.length();
        if (i == n) return 0;
        
        if (memo[i] != -1) return memo[i];
        

        int[] freq = new int[26];
        int maxFreq = 0, uniqueChars = 0;
        int ans = n; 

        for (int j = i; j < n; j++) {
            int charIdx = s.charAt(j) - 'a';

            if (freq[charIdx] == 0) {
                uniqueChars++;
            }
            freq[charIdx]++;
            maxFreq = Math.max(maxFreq, freq[charIdx]);

            int length = j - i + 1;

            if (length == maxFreq * uniqueChars) {
                ans = Math.min(ans, 1 + solve(j + 1, s, memo));
            }
        }

        return memo[i] = ans;
    }
}