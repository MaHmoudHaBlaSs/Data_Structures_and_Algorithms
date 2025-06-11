///  https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/

//Too bad
class Solution {
    private final int MOD = 1_000_000_007;
    private int[][] memo;
    private String target;
    private int targetLen, wordLen;
    private int[][] freq;

    private int ways(int i, int j){
        if(i == targetLen) return 1;
        if(j >= wordLen) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        long ans = 0;
        char c = target.charAt(i);
        for(int k = j; k<wordLen; k++){
            if(freq[k][c-'a'] > 0) {
                ans = (ans + (freq[k][c-'a'] * 1L * ways(i+1, k+1)) ) % MOD; 
            }
        }
        
        return memo[i][j] = (int)ans;
    }

    public int numWays(String[] words, String target) {
        this.target = target;
        targetLen = target.length(); wordLen = words[0].length();
        if(targetLen > wordLen) return 0;
        
        freq = new int[wordLen][26];
        memo = new int[targetLen][wordLen]; 

        for(var word : words){
            for(int i=0; i<wordLen; i++){
                freq[i][word.charAt(i)-'a']++;
            }
        }

        for (int i = 0; i < targetLen; i++)
            Arrays.fill(memo[i], -1);

        return ways(0,0);
    }
}

//Too good
class Solution {
    private final int MOD = 1_000_000_007;

    public int numWays(String[] words, String target) {
        int targetLen = target.length();
        int wordLen = words[0].length();

        if (targetLen > wordLen) return 0;

        int[][] freq = new int[wordLen][26];
        for (String word : words) {
            for (int i = 0; i < wordLen; i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }

        long[] dp = new long[targetLen + 1];
        dp[0] = 1; 

        for (int col = 0; col < wordLen; col++) {
            for (int i = targetLen - 1; i >= 0; i--) {
                int ch = target.charAt(i) - 'a';
                dp[i + 1] = (dp[i + 1] + dp[i] * freq[col][ch]) % MOD;
            }
        }

        return (int) dp[targetLen];
    }
}
