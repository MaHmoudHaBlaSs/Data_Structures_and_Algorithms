///  https://leetcode.com/problems/maximize-the-total-height-of-unique-towers/description/

class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int n = maximumHeight.length;

        long ans = maximumHeight[n-1];
        for(int i=n-2; i>=0; --i){
            maximumHeight[i] = Integer.min(maximumHeight[i], maximumHeight[i+1]-1);

            if(maximumHeight[i] < 1) return -1;

            ans += maximumHeight[i];
        }

        return ans;
    }
}