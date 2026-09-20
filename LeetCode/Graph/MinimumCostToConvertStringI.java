///  https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int oo = 0x3f3f3f3f;
        int[][] adj = new int[26][26];
        
        for(int i=0; i<26; ++i) Arrays.fill(adj[i], oo);

        for(int i=0; i<original.length; ++i){
            int r = original[i] - 'a';
            int c = changed[i] - 'a';

            adj[r][c] = Integer.min(adj[r][c], cost[i]); 
        }

        for(int k=0; k<26; k++){
            for(int i=0; i<26; ++i){
                for(int j=0; j<26; ++j){
                    adj[i][j] = Integer.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }


        long ans = 0;
        for(int i=0; i<source.length(); ++i){
            int r = source.charAt(i) - 'a';
            int c = target.charAt(i) - 'a';

            if(r == c) continue;
            if(adj[r][c] == oo) return -1;

            ans += adj[r][c];
        }

        return ans;
    }
}