///   https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/description/

class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int[] freq1 = new int[8*10_000 + 1], freq2 = new int[8*10_000 + 1];

        for(int i=0; i<nums1.length; ++i){
            freq1[nums1[i]]++;
            freq2[nums2[i]]++;
        }

        int ans = 0;
        for(int i=0; i<freq1.length; ++i){
            int f1 = freq1[i], f2=freq2[i];

            if(((f1+f2) & 1) != 0) return -1;

            if(f1 != f2){
                ans += Math.abs((f1-f2) >> 1); 
            }
        }

        return ans >> 1; 
    }
}