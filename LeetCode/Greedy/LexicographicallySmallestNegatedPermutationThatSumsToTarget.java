///  https://leetcode.com/problems/lexicographically-smallest-negated-permutation-that-sums-to-target/description/

class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long s = (long)n*(n+1) >> 1;

        if(target > s || target < -s || (s - target) % 2 == 1) 
            return new int[]{};

        long d = s-target;
        int[] ans = new int[n];

        for(int i=n; i>0; --i){
            ans[i-1] = i;

            if(2L*i <= d){
                d -= 2*i;
                ans[i-1] *= -1;
            }
        } 

        Arrays.sort(ans);
        return ans;
    }
}