///  https://leetcode.com/problems/minimum-deletion-cost-to-make-all-characters-equal/description/

class Solution {
    public long minCost(String s, int[] cost) {
        long[] charCost = new long[26]; 
        long total = 0;

        for(int i=0; i<s.length(); ++i){
            charCost[s.charAt(i)-'a'] += cost[i];
            total += cost[i];
        }

        long ans = total;
        for(long c : charCost){
            ans = Long.min(ans, total - c);
        }

        return ans; 
    }
}