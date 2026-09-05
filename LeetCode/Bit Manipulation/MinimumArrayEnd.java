///  https://leetcode.com/problems/minimum-array-end/description/

class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        n--;
        int ansIdx = 0;

        for(int i=0; i<31; ++i){
            while((ans & (1L <<ansIdx)) != 0) ansIdx++;

            if((n & (1<<i)) != 0){
                ans = ans ^ (1L <<ansIdx);
            }

            ansIdx++;
        }

        return ans;
    }
}