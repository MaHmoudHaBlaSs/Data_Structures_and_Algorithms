///  https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/description/

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);

        int prev = bottom - 1, ans = 0;
        for(int row : special){
            ans = Integer.max(ans, row - prev - 1);
            prev = row;
        }

        ans = Integer.max(ans, top - prev);
        return ans;
    }
}