///  https://leetcode.com/problems/minimum-cost-to-make-two-binary-strings-equal/description/

class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int zero = 0, one = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)){
                if(s.charAt(i) == '0') zero++;
                else one++;
            }
        }

        int avSwaps = Math.min(zero, one);
        long ans = (long) avSwaps * Math.min(swapCost, 2*flipCost);
        
        zero -= avSwaps;
        one -= avSwaps;
        
        
        int rem = zero + one, remPairs = rem>>1;
        ans += (long) remPairs * Math.min(crossCost+swapCost, 2*flipCost);
        
        rem -= remPairs<<1;
        
        if(rem == 1) ans += flipCost;
        
        return ans; 
    }
}